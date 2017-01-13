package com.coderbike.utils.http;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/1/13 14:41
 */
public class HttpClientUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);

    public static Object doGet(String url) {
        Assert.isTrue(StringUtils.isNotBlank(url), "url is empty!");

        CloseableHttpClient httpClient = HttpClientHolder.getHttpClient();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity, Charset.forName("UTF-8"));
                    return retrunResult(result);
                }
            }
        } catch (Exception e) {
            LOGGER.error("请求异常", e);
        } finally {
            try {
                if (httpGet != null) {
                    httpGet.releaseConnection();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                LOGGER.error("关闭httpClient异常", e);
            }
        }
        throw new RuntimeException("get请求失败");
    }

    public static Object doPost(String url, String postBody) {
        CloseableHttpClient httpClient = HttpClientHolder.getHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(postBody, Charset.forName("UTF-8")));

        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity, "UTF-8");
                return retrunResult(result);
            }
        } catch (Exception e) {
            LOGGER.error("请求异常", e);
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    LOGGER.error("关闭httpResponse异常", e);
                }
            }
        }

        throw new RuntimeException("post请求异常");
    }

    private static Object retrunResult(String content) {
        if (content.startsWith("{")) {
            return JSONObject.parseObject(content);
        } else if (content.startsWith("[")) {
            return JSONArray.parseArray(content);
        } else {
            return content;
        }
    }
}

package com.coderbike.utils.http;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

/**
 * <p>httpClient 工具类<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/1/13 13:58
 */
public class HttpClientHolder {

    private HttpClientHolder() {}

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientHolder.class);

    // 池化管理
    private static PoolingHttpClientConnectionManager poolConnManager = null;

    // CloseableHttpClient
    private static CloseableHttpClient httpClient;

    // 请求配置
    private static RequestConfig requestConfig;

    private static Properties properties;

    static {
        InputStream inputStream = HttpClientHolder.class.getClassLoader().getResourceAsStream("httpConfig.properties");
        if (inputStream == null) {
            throw new RuntimeException("读取配置文件失败");
        }

        try {
            properties.load(inputStream);

            SSLContextBuilder builder = new SSLContextBuilder();
            builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                    builder.build());
            // 配置同时支持 HTTP 和 HTPPS
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create().register(
                    "http", PlainConnectionSocketFactory.getSocketFactory()).register(
                    "https", sslsf).build();

            // 初始化连接管理器
            poolConnManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            // 最大连接数
            int maxTotal = Integer.valueOf(properties.getProperty("httpClient.maxConnection"));
            poolConnManager.setMaxTotal(maxTotal);
            // 设置最大路由
            int maxPerRout = Integer.valueOf(properties.getProperty("httpClient.maxConnectionPerRoute"));
            poolConnManager.setDefaultMaxPerRoute(maxPerRout);

            // 初始化requestConfig
            int socketTimeout = Integer.valueOf(properties.getProperty("httpClient.socketTimeout"));
            int connectTimeout = Integer.valueOf(properties.getProperty("httpClient.connectTimeout"));
            int connectionRequestTimeout = Integer.valueOf(properties.getProperty("httpClient.connectionRequestTimeout"));
            requestConfig = RequestConfig.custom()
                                         .setConnectionRequestTimeout(connectionRequestTimeout)
                                         .setSocketTimeout(socketTimeout)
                                         .setConnectTimeout(connectTimeout)
                                         .build();

            httpClient = getConnection();
        } catch (IOException e) {
            LOGGER.error("load properties 异常", e);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("NoSuchAlgorithmException", e);
        } catch (KeyStoreException e) {
            LOGGER.error("KeyStoreException", e);
        } catch (KeyManagementException e) {
            LOGGER.error("KeyManagementException", e);
        }
    }

    private static CloseableHttpClient getConnection() {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(poolConnManager)
                .setDefaultRequestConfig(requestConfig)
                .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                .build();

        return httpClient;
    }

    public static CloseableHttpClient getHttpClient() {
        return httpClient;
    }
}

package com.coderbike.utils;

import com.coderbike.utils.context.RequestContextUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2016/12/14 14:39
 */
public class RenderUtils {

    private static final String ENCODE = "UTF-8";

    private static final String TEXT = "text/plain";
    private static final String JSON = "application/json";
    private static final String XML = "text/xml";
    private static final String HTML = "text/html";
    private static final String JAVASCRIPT = "text/javascript";

    private static void render(final String context, final String encode, final String contextType) {
        HttpServletResponse response = RequestContextUtil.getResponse();
        response.setCharacterEncoding(encode);
        response.setContentType(contextType);


        Writer writer = null;
        try {
            writer = response.getWriter();
            writer.write(context);
        } catch (IOException e) {
            throw new RuntimeException("render exception", e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException("writer close exception", e);
                }
            }
        }
    }

    public static void rendJson(String context) {
        render(context, ENCODE, JSON);
    }
}

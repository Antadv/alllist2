package com.coderbike.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>cookie util<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/12 16:30
 */
public class CookieUtils {

    /**
     * <p>获取cookie的值<p/>
     * author: imant
     * date: 2016/12/12 16:30
     */
    public static String getValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * <p>获取cookie<p/>
     * author: imant
     * date: 2016/12/12 16:30
     */
    public static Cookie getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    /**
     * <p>删除cookie<p/>
     * author: imant
     * date: 2017/1/11 10:34
     */
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
        Cookie cookie = getCookie(request, cookieName);
        if (cookie != null) {
            cookie.setPath(request.getContextPath() + "/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }
}

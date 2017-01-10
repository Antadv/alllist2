package com.coderbike.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>cookie util<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/12 16:30
 */
public class CookieUtils {

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

    public static void deleteCookie(HttpServletRequest request, String cookieName) {

    }
}

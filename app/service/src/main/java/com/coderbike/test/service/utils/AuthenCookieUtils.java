package com.coderbike.test.service.utils;

import com.coderbike.common.constant.CommonConstant;
import com.coderbike.utils.context.RequestContextUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.Assert;

import javax.servlet.http.Cookie;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2016/12/14 15:28
 */
public class AuthenCookieUtils {

    /**
     * <p>
     *  发送客户端认证cookie
     *  格式：userId:md5(password+authSecret)
     *  参考http://www.liaoxuefeng.com/article/001437480923144e567335658cc4015b38a595bb006aa51000
     * <p/>
     * author: imant
     * date: 2016/12/14 15:58
     */
    public static void addAuthCookie(long userId, String password, String authSecret) {

        Assert.notNull(password, "password can't be null");
        Assert.notNull(authSecret, "authenSecret can't be null");

        StringBuilder sb = new StringBuilder();
        sb.append(userId).append(":").append(DigestUtils.md5Hex(password + authSecret));

        Cookie cookie = new Cookie(CommonConstant.LOGIN_COOKIE, sb.toString());
        cookie.setHttpOnly(true);
        cookie.setMaxAge(CommonConstant.COOKIE_EXPIRE);
        cookie.setPath(RequestContextUtil.getRequest().getContextPath() + "/");
        RequestContextUtil.getResponse().addCookie(cookie);
    }
}

package com.coderbike.service.authen;

import com.coderbike.entity.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>登录验证接口<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/12 16:22
 */
public interface Authenticator {

    /**
     * <p>登录验证<p/>
     * author: liubingguang
     * date: 2016/12/12 16:24
     */
    User authenticate(HttpServletRequest request, HttpServletResponse response);
}

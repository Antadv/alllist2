package com.coderbike.service.authen;

import com.coderbike.entity.user.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>oauth2.0登录认证<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/12 16:28
 */
@Service
public class Oauth2CookieAuthenticator implements Authenticator {

    @Override
    public User authenticate(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}

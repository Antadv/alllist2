package com.coderbike.web.authen;

import com.coderbike.common.constant.CommonConstant;
import com.coderbike.entity.passport.LocalAuth;
import com.coderbike.entity.user.User;
import com.coderbike.service.LocalAuthService;
import com.coderbike.service.UserService;
import com.coderbike.utils.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/12 16:25
 */
@Service
public class LocalCookieAuthenticator implements Authenticator {

    @Value("${authSecret}")
    private String authSecret;

    @Autowired
    private UserService userService;

    @Autowired
    private LocalAuthService authService;

    /**
     * <p>口令登录验证<p/>
     * author: liubingguang
     * date: 2016/12/12 17:36
     */
    @Override
    public User authenticate(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = CookieUtils.getCookie(request, CommonConstant.LOGIN_COOKIE);
        String cookieValue = cookie.getValue();
        if (cookie == null
                || cookie.getMaxAge() < System.currentTimeMillis()
                || StringUtils.isBlank(cookieValue)
                || !cookieValue.contains(":")) {
            return null;
        }

        return getUserByCookie(cookie);
    }

    /**
     * <p>根据cookie查出user<p/>
     * author: liubingguang
     * date: 2016/12/12 17:39
     */
    private User getUserByCookie(Cookie cookie) {
        String[] values = cookie.getValue().split(":");
        Long userId = Long.parseLong(values[0]);
        User user = userService.findById(userId);
        if (user != null) {
            LocalAuth localAuth = authService.findByUserId(userId);
            String password = localAuth.getPassword();
        }
        return null;
    }
}

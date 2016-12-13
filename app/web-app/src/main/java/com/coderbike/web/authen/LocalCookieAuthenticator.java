package com.coderbike.web.authen;

import com.coderbike.common.constant.CommonConstant;
import com.coderbike.entity.passport.LocalAuth;
import com.coderbike.entity.user.User;
import com.coderbike.service.LocalAuthService;
import com.coderbike.service.UserService;
import com.coderbike.utils.CookieUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
        if (cookie == null
                || cookie.getMaxAge() < System.currentTimeMillis()
                || StringUtils.isBlank(cookie.getValue())
                || !cookie.getValue().contains(":")) {
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
        Assert.isTrue(NumberUtils.isNumber(values[0]), "非法cookie值");

        Long userId = Long.parseLong(values[0]);
        User user = userService.findById(userId);
        if (user != null) {
            LocalAuth localAuth = authService.findByUserId(userId);
            String password = localAuth.getPassword();
            String md5Str = Md5Crypt.md5Crypt(password.getBytes(), authSecret);
            if (md5Str.equals(values[1])) {
                return user;
            }
        }
        return null;
    }
}

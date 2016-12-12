package com.coderbike.web.authen;

import com.coderbike.common.constant.CommonConstant;
import com.coderbike.entity.user.User;
import com.coderbike.service.UserService;
import com.coderbike.utils.CookieUtils;
import com.coderbike.utils.context.SpringContextUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *     登录认证工具类，更通用cookie操作请参考
 *     @see com.coderbike.utils.CookieUtils
 * <p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/12 16:31
 */
public class AuthCookieUtils {

    private static UserService userService = SpringContextUtils.getBean("userService");

    /**
     * <p>
     *     用户cookie格式：userId:md5Str
     * <p/>
     * author: liubingguang
     * date: 2016/12/12 16:49
     */
    public static User getUserByCookie(HttpServletRequest request) {
        Cookie cookie = CookieUtils.getCookie(request, CommonConstant.LOGIN_COOKIE);
        String cookieValue = cookie.getValue();
        if (cookie == null
                || cookie.getMaxAge() < System.currentTimeMillis()
                || StringUtils.isBlank(cookieValue)
                || !cookieValue.contains(":")) {
            return null;
        }

        String[] userIdAndMd5Str = cookieValue.split(":");
        Long userId = Long.parseLong(userIdAndMd5Str[0]);

        User user = userService.findById(userId);
        if (user != null) {
        }
        return null;
    }
}

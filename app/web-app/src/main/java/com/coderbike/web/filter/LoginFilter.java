package com.coderbike.web.filter;

import com.coderbike.common.context.UserContext;
import com.coderbike.entity.user.User;
import com.coderbike.utils.ArrayUtils;
import com.coderbike.utils.context.SpringContextUtils;
import com.coderbike.test.service.authen.Authenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>登录过滤器<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/12 16:18
 */
public class LoginFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginFilter.class);

    private Authenticator[] authenticators = new Authenticator[2];
    private String[] excludedUrl;
    private String[] staticResource;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        authenticators[0] = SpringContextUtils.getBean("localCookieAuthenticator");
        authenticators[1] = SpringContextUtils.getBean("oauth2CookieAuthenticator");

        excludedUrl = new String[]{"/passport/login", "/passport/register",
                "/passport/loginSubmit", "/passport/registerSubmit"};

        staticResource = new String[]{".js", ".css", ".png", ".jpg", ".gif"};
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURI();
        if (ArrayUtils.contain(staticResource, url) || ArrayUtils.contain(excludedUrl, url)) {
            chain.doFilter(servletRequest, servletResponse);
        } else {
            User user = tryGetAuthenticatedUser(request, response);
            if (user != null) {
                try (UserContext userContext = new UserContext(user)) {
                    chain.doFilter(servletRequest, servletResponse);
                } catch (Exception e) {
                    LOGGER.error("UserContext close 异常", e);
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/passport/login");
            }
        }

    }

    @Override
    public void destroy() {
    }

    private User tryGetAuthenticatedUser(HttpServletRequest request, HttpServletResponse response) {
        for (Authenticator authenticator : authenticators) {
            User user = authenticator.authenticate(request, response);
            if (user != null) {
                return user;
            }
        }
        return null;
    }
}

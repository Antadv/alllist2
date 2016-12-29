package com.coderbike.test.utils;

import com.coderbike.test.base.BaseTest;
import com.coderbike.utils.context.SpringContextUtils;
import com.coderbike.test.service.authen.Authenticator;
import org.junit.Test;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/13 11:07
 */
public class SpringContextUtilsTest extends BaseTest {

    @Test
    public void test() {
        Authenticator localAuthenticator = SpringContextUtils.getBean("localCookieAuthenticator");
        Authenticator oauth2CookieAuthenticator = SpringContextUtils.getBean("oauth2CookieAuthenticator");
        System.out.println(localAuthenticator);
        System.out.println(oauth2CookieAuthenticator);
    }
}

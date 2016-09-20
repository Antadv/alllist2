package com.coderbike.service;

import com.coderbike.baseTest.BaseTest;
import com.coderbike.entity.User;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/18 17:14
 */
public class UserServiceTest extends BaseTest {

    @Resource
    private UserService userService;

    @Test
    public void testSelect() {
        User user = userService.selectUserById(1);
        //Logger.info(user.getUserName());
        System.out.println(user.getUserName());
    }

}

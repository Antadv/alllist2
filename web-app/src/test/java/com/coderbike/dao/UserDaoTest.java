package com.coderbike.dao;

import com.coderbike.baseTest.BaseTest;
import com.coderbike.dao.jpa.UserDao;
import com.coderbike.entity.User;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/21 18:01
 */
public class UserDaoTest extends BaseTest {

    @Resource
    private UserDao userDao;

    @Test
    public void test() {
        User user = userDao.findById(1);
        System.out.println(user.getUserName());
    }
}

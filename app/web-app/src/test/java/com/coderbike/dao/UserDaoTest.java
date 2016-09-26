package com.coderbike.dao;

import com.coderbike.baseTest.BaseTest;
import com.coderbike.dao.jpa.UserJpaDao;
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
    private UserJpaDao userJpaDao;

    @Test
    public void test() {
        User user = userJpaDao.getOne(1);
        System.out.println(user.getUserName());
    }
}

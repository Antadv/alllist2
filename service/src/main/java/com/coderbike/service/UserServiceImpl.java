package com.coderbike.service;

import com.coderbike.dao.UserDao;
import com.coderbike.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/20 15:18
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User selectUserById(Integer userId) {
        return userDao.selectUserById(userId);
    }
}

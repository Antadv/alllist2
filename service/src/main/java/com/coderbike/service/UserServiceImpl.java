package com.coderbike.service;

import com.coderbike.dao.jpa.UserDao;
import com.coderbike.dao.mybatis.UserMDao;
import com.coderbike.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/20 15:18
 */

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Resource
    private UserMDao userMDao;

    @Resource
    private UserDao userDao;

    public User selectUserById(Integer userId) {
        return userMDao.selectUserById(userId);
    }

    public User findById(Integer userId) {
        //return userDao.findById(userId);
        return userDao.findOne(1);
    }
}

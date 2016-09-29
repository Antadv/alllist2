package com.coderbike.service;

import com.coderbike.core.service.GenericServiceImpl;
import com.coderbike.dao.jpa.UserJpaDao;
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
public class UserServiceImpl extends GenericServiceImpl<User, Integer, UserJpaDao> implements UserService {

    @Resource
    private UserJpaDao userJpaDao;

    public UserJpaDao getDao() {
        return userJpaDao;
    }
}

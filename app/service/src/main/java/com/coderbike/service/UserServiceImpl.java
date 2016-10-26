package com.coderbike.service;

import com.coderbike.core.service.GenericServiceImpl;
import com.coderbike.dao.jpa.UserJpaDao;
import com.coderbike.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/20 15:18
 */

@Transactional(readOnly = true)
@Service
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService {

    @Autowired
    private UserJpaDao userJpaDao;

    @Override
    public User findById(Integer userId) {
        return userJpaDao.findById(userId);
    }
}

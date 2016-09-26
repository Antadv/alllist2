package com.coderbike.service;

import com.coderbike.core.service.GenericServiceImpl;
import com.coderbike.dao.jpa.UserJpaDao;
import com.coderbike.dao.mybatis.UserMybatisDao;
import com.coderbike.entity.User;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/20 15:18
 */

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Integer, UserJpaDao, UserMybatisDao> implements UserService {

    @Resource
    private UserJpaDao userJpaDao;

    public UserServiceImpl(JpaEntityInformation<User, Integer> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public User selectUserById(Integer userId) {
        return userJpaDao.getOne(1);
    }

    public User findById(Integer userId) {
        return userJpaDao.getOne(1);
    }

    public UserJpaDao getJpaDao() {
        return null;
    }

    public UserMybatisDao getMybatisDao() {
        return null;
    }
}

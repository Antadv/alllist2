package com.coderbike.service;

import com.coderbike.core.service.GenericService;
import com.coderbike.dao.jpa.UserJpaDao;
import com.coderbike.dao.mybatis.UserMybatisDao;
import com.coderbike.entity.User;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/20 15:18
 */
public interface UserService extends GenericService<User, Integer, UserJpaDao, UserMybatisDao> {

    User selectUserById(Integer userId);

    User findById(Integer userId);

}

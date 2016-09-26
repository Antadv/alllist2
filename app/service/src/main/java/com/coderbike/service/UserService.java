package com.coderbike.service;

import com.coderbike.entity.User;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/20 15:18
 */
public interface UserService {

    User selectUserById(Integer userId);

    User findById(Integer userId);

}

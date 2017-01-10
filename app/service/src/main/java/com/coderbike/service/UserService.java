package com.coderbike.service;

import com.coderbike.core.service.GenericService;
import com.coderbike.entity.user.User;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/20 15:18
 */
public interface UserService extends GenericService<User, Long> {

    User findById(Long userId);

    User findByUsernameAndPwd(String username, String password);

    User register(User user, String password);

    void deleteAccount(Long userId);
}

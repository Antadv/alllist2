package com.coderbike.dao;

import com.coderbike.entity.User;
import org.springframework.stereotype.Repository;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/18 17:01
 */

@Repository
public interface UserDao {

    User selectUserById(Integer userId);
}

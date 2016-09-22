package com.coderbike.dao.jpa;

import com.coderbike.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/21 17:54
 */

public interface UserDao extends JpaRepository<User, Integer> {

    @Query("from User u where u.userId=?")
    User findById(Integer userId);
}

package com.coderbike.dao.jpa;

import com.coderbike.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/27 1:04
 */

public interface UserJpaDao extends JpaRepository<User, Integer> {

    @Query("from User u where u.id=?")
    User findById(Integer userId);
}

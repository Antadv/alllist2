package com.coderbike.dao.mybatis;

import com.coderbike.entity.user.User;
import org.springframework.stereotype.Repository;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/18 17:01
 */

@Repository
public interface UserMDao {

    User selectUserById(Integer id);
}

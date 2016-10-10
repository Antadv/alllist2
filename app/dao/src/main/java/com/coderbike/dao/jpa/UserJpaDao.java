package com.coderbike.dao.jpa;

import com.coderbike.core.repository.GenericJpaDao;
import com.coderbike.entity.User;
import org.springframework.stereotype.Repository;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/27 1:04
 */

@Repository
public interface UserJpaDao extends GenericJpaDao<User, Integer> {

}

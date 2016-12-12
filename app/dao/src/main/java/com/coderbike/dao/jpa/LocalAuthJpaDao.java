package com.coderbike.dao.jpa;

import com.coderbike.entity.passport.LocalAuth;
import org.springframework.data.jpa.repository.Query;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/12 17:49
 */
public interface LocalAuthJpaDao {

    @Query("from LocalAuth la where la.delStatus=false and la.userId=?")
    LocalAuth findByUserId(Long userId);
}

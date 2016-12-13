package com.coderbike.dao.jpa;

import com.coderbike.core.repository.BaseRepository;
import com.coderbike.entity.passport.LocalAuth;
import org.springframework.data.jpa.repository.Query;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/12 17:49
 */
public interface LocalAuthJpaDao extends BaseRepository<LocalAuth, Long> {

    @Query("from LocalAuth la where la.deleteStatus=false and la.userId=?")
    LocalAuth findByUserId(Long userId);
}

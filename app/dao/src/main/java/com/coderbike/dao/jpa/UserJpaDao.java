package com.coderbike.dao.jpa;

import com.coderbike.core.repository.BaseRepository;
import com.coderbike.entity.user.User;
import org.springframework.data.jpa.repository.Query;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/27 1:04
 */

public interface UserJpaDao extends BaseRepository<User, Long> {

    @Query("from User u where u.id=?")
    User findById(Long userId);

    @Query(value = "select u.* from t_user u inner join t_local_auth la on u.id=la.user_id where u.delete_status='0' and u.username=?1 and la.password=?2", nativeQuery = true)
    User findByUsernameAndPwd(String username, String password);
}

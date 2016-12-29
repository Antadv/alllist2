package com.coderbike.test.service.impl;

import com.coderbike.core.service.GenericServiceImpl;
import com.coderbike.dao.jpa.UserJpaDao;
import com.coderbike.entity.passport.LocalAuth;
import com.coderbike.entity.user.User;
import com.coderbike.test.service.LocalAuthService;
import com.coderbike.test.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/20 15:18
 */

@Transactional(readOnly = true)
@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {

    @Value("${passwordSalt}")
    private String passwordSalt;

    @Autowired
    private LocalAuthService localAuthService;

    @Autowired
    private UserJpaDao userJpaDao;

    @Override
    public User findById(Long userId) {
        return userJpaDao.findById(userId);
    }

    @Override
    public User findByUsernameAndPwd(String username, String password) {
        return userJpaDao.findByUsernameAndPwd(username, DigestUtils.md5Hex(password + passwordSalt));
    }

    @Override
    @Transactional
    public User register(User user, String password) {
        Assert.notNull(user, "user can't be null");
        Assert.isTrue(StringUtils.isNotBlank(password), "password can't be blank");

        user = save(user);
        LocalAuth localAuth = new LocalAuth();
        localAuth.setPassword(DigestUtils.md5Hex(password + passwordSalt));
        localAuth.setUserId(user.getId());
        localAuthService.save(localAuth);

        return user;
    }
}

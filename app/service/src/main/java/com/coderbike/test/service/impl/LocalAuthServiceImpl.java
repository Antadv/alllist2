package com.coderbike.test.service.impl;

import com.coderbike.core.service.GenericServiceImpl;
import com.coderbike.dao.jpa.LocalAuthJpaDao;
import com.coderbike.entity.passport.LocalAuth;
import com.coderbike.test.service.LocalAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/12 17:47
 */
@Service
public class LocalAuthServiceImpl extends GenericServiceImpl<LocalAuth, Long> implements LocalAuthService {

    @Autowired
    private LocalAuthJpaDao authJpaDao;

    @Override
    public LocalAuth findByUserId(Long userId) {
        return authJpaDao.findByUserId(userId);
    }
}

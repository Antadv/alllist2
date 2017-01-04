package com.coderbike.service;

import com.coderbike.core.service.GenericService;
import com.coderbike.entity.passport.LocalAuth;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/12 17:45
 */
public interface LocalAuthService extends GenericService<LocalAuth, Long> {

    LocalAuth findByUserId(Long userId);
}

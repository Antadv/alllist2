package com.coderbike.core.service;

import com.coderbike.core.jpa.JpaBaseDao;
import com.coderbike.core.entity.BaseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/26 16:19
 */

@Transactional(readOnly = true)
public abstract class AbstactService<T extends BaseEntity, ID extends Serializable> {

    @Resource
    private JpaBaseDao jpaBaseDao;

    protected T save(T t) {
        Assert.notNull(t, "保存实体为空");

        Date date = new Date();
        if (t.getId() == null) {
            /** new add **/
            t.setFirstTime(date);
        }
        t.setLastTime(date);
        return (T) jpaBaseDao.save(t);
    }
}

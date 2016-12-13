package com.coderbike.entity.passport;

import com.coderbike.core.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>口令登录<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/1/7 10:59
 */
@Entity
@Table(name = "T_LOCAL_AUTH")
public class LocalAuth extends BaseEntity{

    private Long userId;     //用户id
    private String password; //登录密码

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

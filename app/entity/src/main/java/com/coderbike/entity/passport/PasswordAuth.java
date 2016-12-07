package com.coderbike.entity.passport;

import com.coderbike.core.entity.BaseEntity;

import javax.persistence.Entity;

/**
 * <p>口令登录<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/1/7 10:59
 */
@Entity(name = "T_PASSWORD_AUTH")
public class PasswordAuth extends BaseEntity{

    private Integer userId;     //用户id
    private String password;    //登录密码

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

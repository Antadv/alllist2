package com.coderbike.entity;

import com.coderbike.entity.base.BaseEntity;

import javax.persistence.*;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/20 15:11
 */

@Entity
@Table(name = "T_USER")
public class User extends BaseEntity {

    private String userName;
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}

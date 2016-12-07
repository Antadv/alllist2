package com.coderbike.entity.user;

import com.coderbike.core.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>用户资料<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/20 15:11
 */

@Entity
@Table(name = "T_USER")
public class User extends BaseEntity {

    private String userName;        //用户名

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }
}

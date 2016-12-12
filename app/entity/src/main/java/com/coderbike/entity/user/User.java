package com.coderbike.entity.user;

import com.coderbike.core.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * <p>用户资料<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/20 15:11
 */

@Entity
@Table(name = "T_USER")
public class User extends BaseEntity {

    private String userName;    //用户名
    private Boolean sex;        //性别 0 male, 1 female
    private Integer age;        //年龄
    private Date lastLoginDate; //最后登录时间

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

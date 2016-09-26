package com.coderbike.core.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * <p>所有entity的父类，用于继承通用属性<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/23 16:44
 */

@MappedSuperclass
public abstract class BaseEntity {

    protected Integer id;                   //id
    protected Date firstTime;               //第一次插入时间
    protected Date lastTime;                //最后修改时间
    protected boolean deleteStatus = false; //逻辑删除状态

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public boolean isDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}

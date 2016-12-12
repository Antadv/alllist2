package com.coderbike.core.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * <p>所有entity的父类，用于继承通用属性<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/23 16:44
 */

@MappedSuperclass
public abstract class BaseEntity {

    protected Long id;                      //id
    protected Date createDate;              //创建时间
    protected Date updateDate;              //修改时间
    protected String delReason;             //删除描述
    protected boolean deleteStatus = false; //逻辑删除状态

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getDelReason() {
        return delReason;
    }

    public void setDelReason(String delReason) {
        this.delReason = delReason;
    }

    @Override
    public String toString() {
        Field[] fields = getClass().getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);

        int capacity = fields.length;
        StringBuilder builder = new StringBuilder(capacity);
        builder.append("{");
        for (int i = 0; i < capacity; i++) {
            try {
                builder.append(fields[i].getName())
                        .append("=")
                        .append(fields[i].get(this));

                if (i < capacity - 1) {
                    builder.append(", ");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("illegal access!", e);
            }
        }
        builder.append("}");
        return builder.toString();
    }
}

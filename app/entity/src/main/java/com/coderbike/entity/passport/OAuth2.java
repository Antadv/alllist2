package com.coderbike.entity.passport;

import com.coderbike.core.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>oAuth2登录认证<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/7 10:59
 */
@Entity
@Table(name = "T_OAUTH2")
public class OAuth2 extends BaseEntity {

    private Integer userId;
    private Integer oauthType;
    private String oauthName;
    private String oauthId;
    private String oauthKey;
    private String oauthSecret;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOauthType() {
        return oauthType;
    }

    public void setOauthType(Integer oauthType) {
        this.oauthType = oauthType;
    }

    public String getOauthName() {
        return oauthName;
    }

    public void setOauthName(String oauthName) {
        this.oauthName = oauthName;
    }

    public String getOauthId() {
        return oauthId;
    }

    public void setOauthId(String oauthId) {
        this.oauthId = oauthId;
    }

    public String getOauthKey() {
        return oauthKey;
    }

    public void setOauthKey(String oauthKey) {
        this.oauthKey = oauthKey;
    }

    public String getOauthSecret() {
        return oauthSecret;
    }

    public void setOauthSecret(String oauthSecret) {
        this.oauthSecret = oauthSecret;
    }
}

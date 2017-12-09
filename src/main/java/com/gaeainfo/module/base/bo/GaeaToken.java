package com.gaeainfo.module.base.bo;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Rock on 2017/5/2.
 */
public class GaeaToken {

    private String tokenId;
    private String loginName;
    private Date loginTime;
    private String roleName;
    private Object userInfo;

    public GaeaToken(){
        this.tokenId = UUID.randomUUID().toString();
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Object getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Object userInfo) {
        this.userInfo = userInfo;
    }
}

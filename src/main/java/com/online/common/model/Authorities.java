package com.online.common.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-11-18
 * Time: 上午11:40
 * To change this template use File | Settings | File Templates.
 */
public class Authorities implements Serializable{
    private long id;

    private String authCode;

    private String authName;

    private char authStatus;

    private Date createDate;

    private String createStaff;

    private Date updateDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public char getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(char authStatus) {
        this.authStatus = authStatus;
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getCreateStaff() {
        return createStaff;
    }

    public void setCreateStaff(String createStaff) {
        this.createStaff = createStaff;
    }

    @Override
    public boolean equals(Object obj) {
        Authorities auth = (Authorities)obj;
        if(this.getAuthCode().equals(auth.getAuthCode()))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Auth:authCode:"+this.getAuthCode()+";authName:"+this.getAuthName()+";status:"+this.getAuthStatus();
    }
}

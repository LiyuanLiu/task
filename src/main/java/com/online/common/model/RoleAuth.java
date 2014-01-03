package com.online.common.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-11-18
 * Time: 下午1:19
 * To change this template use File | Settings | File Templates.
 */
public class RoleAuth implements Serializable{
    private long id;

    private String roleCode;

    private String authCode;

    private char status;

    private Date createDate;

    private int createStaff;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getCreateStaff() {
        return createStaff;
    }

    public void setCreateStaff(int createStaff) {
        this.createStaff = createStaff;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}

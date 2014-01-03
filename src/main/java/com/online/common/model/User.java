package com.online.common.model;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-11-13
 * Time: 上午10:43
 * To change this template use File | Settings | File Templates.
 */
@Alias(value="tf_f_user")
public class User implements Serializable {
    private long id;

    private String userCode;

    private String userName;

    private String userPassword;

    private int userType;

    private Date createDate;

    private Date updateDate;

    private char status;

    private String createStaffCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
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

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getCreateStaffCode() {
        return createStaffCode;
    }

    public void setCreateStaffCode(String createStaffCode) {
        this.createStaffCode = createStaffCode;
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        if(this.getUserName().equals(user.getUserName())
                && this.getUserCode().equals(user.getUserCode()))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return this.getUserName()+" and password is secret";
    }
}

package com.online.common.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-11-18
 * Time: 上午11:36
 * To change this template use File | Settings | File Templates.
 */
public class Role implements Serializable{
    private long id;

    private String roleCode;

    private String roleName;

    private char roleStatus;

    private Date createDate;

    private String createStaff;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public char getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(char roleStatus) {
        this.roleStatus = roleStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getCreateStaff() {
        return createStaff;
    }

    public void setCreateStaff(String createStaff) {
        this.createStaff = createStaff;
    }

    @Override
    public boolean equals(Object obj) {
        Role role = (Role)obj;
        if(this.getRoleCode().equals(role.getRoleCode()))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Role->roleCode:"+this.getRoleCode()+";roleName:"+this.getRoleName()+";status:"+this.getRoleStatus();
    }
}

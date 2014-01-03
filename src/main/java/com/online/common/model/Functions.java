package com.online.common.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-11-18
 * Time: 上午11:19
 * To change this template use File | Settings | File Templates.
 */
public class Functions implements Serializable{
    private long id;

    private String funcCode;

    private String funcName;

    private String funcDesc;

    private String funcUrl;

    private char funcStatus;

    private Date createDate;

    private Date updateDate;

    private String createStaff;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getFuncDesc() {
        return funcDesc;
    }

    public void setFuncDesc(String funcDesc) {
        this.funcDesc = funcDesc;
    }

    public String getFuncUrl() {
        return funcUrl;
    }

    public void setFuncUrl(String funcUrl) {
        this.funcUrl = funcUrl;
    }

    public char getFuncStatus() {
        return funcStatus;
    }

    public void setFuncStatus(char funcStatus) {
        this.funcStatus = funcStatus;
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

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getCreateStaff() {
        return createStaff;
    }

    public void setCreateStaff(String createStaff) {
        this.createStaff = createStaff;
    }

    @Override

    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Functions func = (Functions) obj;
        if(this.getFuncCode().equals(func.getFuncCode()))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Func->funcCode:"+this.getFuncCode()+";funcName:"+this.getFuncName()+";status:"+this.getFuncStatus();
    }
}

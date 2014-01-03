package com.online.common.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-11-18
 * Time: 下午1:18
 * To change this template use File | Settings | File Templates.
 */
public class AuthFunc implements Serializable{
    private long id;

    private String authCode;

    private String funcCode;

    private char status;

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

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
}

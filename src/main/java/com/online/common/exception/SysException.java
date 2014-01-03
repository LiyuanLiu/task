package com.online.common.exception;

import org.apache.log4j.Logger;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-11-26
 * Time: 上午10:45
 * To change this template use File | Settings | File Templates.
 */
public class SysException extends Exception implements Serializable{
    private static Logger log = Logger.getLogger(SysException.class);

    public SysException() {
    }

    public SysException(String message) {
        super(message);
    }

    public SysException(String message, Throwable cause) {
        super(message, cause);
    }

    public SysException(int errorCode, String message, Throwable cause){
        super(message,cause);
        log.info("系统发生异常，异常代码："+errorCode+",异常原因："+message);
        log.error(message,cause);
    }
}

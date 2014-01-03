package com.online.common.exception;
import org.apache.log4j.Logger;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-11-26
 * Time: 上午10:43
 * To change this template use File | Settings | File Templates.
 */
public class AppException extends Exception implements Serializable{
    private static Logger logger = Logger.getLogger(AppException.class);

    public AppException() {
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(int errorCode, String message, Throwable cause){
           super(message,cause);
          logger.info("应用层面异常，异常代码："+errorCode+",异常原因："+message);
          logger.error(message,cause);
    }
}

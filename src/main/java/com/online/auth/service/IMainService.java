package com.online.auth.service;

import com.online.common.exception.AppException;
import com.online.common.exception.SysException;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-12-5
 * Time: 下午1:57
 * To change this template use File | Settings | File Templates.
 */
public interface IMainService {
    public Map<String, Object> getCurrentWeather(String areaCode) throws AppException, SysException;
}

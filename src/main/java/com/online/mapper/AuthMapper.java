package com.online.mapper;

import com.online.common.model.User;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-11-25
 * Time: 上午10:39
 * To change this template use File | Settings | File Templates.
 */
public interface AuthMapper {
    public int getUserExists(Map<String,String> parameterMap);

    public User getUserByName(String userName);
}

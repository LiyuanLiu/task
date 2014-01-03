package com.online.auth.service.impl;

import com.online.auth.service.IAuthService;
import com.online.common.model.User;
import com.online.mapper.AuthMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-11-25
 * Time: 下午1:38
 * To change this template use File | Settings | File Templates.
 */
@Service(value="authService")
public class AuthServiceImpl implements IAuthService{
    private Logger logger = Logger.getLogger(AuthServiceImpl.class);

    @Autowired
    private AuthMapper authMapper;

    public AuthMapper getAuthMapper() {
        return authMapper;
    }

    public void setAuthMapper(AuthMapper authMapper) {
        this.authMapper = authMapper;
    }

    public boolean getUserExists(User user) {
        Map<String, String> parameterMap = new HashMap();
        parameterMap.put("userName",user.getUserName());
        parameterMap.put("userPassword",user.getUserPassword());
        int result = authMapper.getUserExists(parameterMap);
        if(result > 0)
            return true;
        return false;
    }

    public User getUserByName(String userName) {
        return authMapper.getUserByName(userName);
    }
}

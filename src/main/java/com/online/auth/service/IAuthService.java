package com.online.auth.service;

import com.online.common.model.User;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-11-25
 * Time: 下午1:37
 * To change this template use File | Settings | File Templates.
 */
@Service
public interface IAuthService {
    public boolean getUserExists(User user);

    public User getUserByName(String userName);
}

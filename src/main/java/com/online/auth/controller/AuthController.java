package com.online.auth.controller;

import com.online.auth.service.IAuthService;
import com.online.common.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-11-25
 * Time: 上午9:26
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value="/login")
public class AuthController{
    private static Logger logger = Logger.getLogger(AuthController.class)  ;

    private User user;
    @Autowired
    private IAuthService authService;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @RequestMapping(value="/doLogin",method=RequestMethod.POST)
    public String login(HttpServletRequest request,User user,
                        HttpSession session){
        boolean result = authService.getUserExists(user);
        if(result){
            User user2 = authService.getUserByName(user.getUserName());
            session.setAttribute("user",user2);
            return "redirect:/"+user2.getUserCode()+"/mainPage";
        }
        return "fail";
    }
}

package com.online.auth.controller;

import com.online.auth.service.IMainService;
import com.online.common.exception.AppException;
import com.online.common.exception.SysException;
import com.online.common.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-11-28
 * Time: 上午9:33
 * To change this template use File | Settings | File Templates.
 */
@Controller
@SessionAttributes("user")
public class MainPageController {

    private static Logger logger = Logger.getLogger(MainPageController.class);

    @Autowired
    private IMainService mainService;

    @RequestMapping(value="/{id}/mainPage",method= RequestMethod.GET)
    public String gotoMain(@PathVariable("id") String id, @ModelAttribute("user") User user){
          System.out.println("come here");
          return "main";
    }

    //weather
    @RequestMapping(value="/{id}/news",method=RequestMethod.GET)
    public ModelAndView newsSpider(@PathVariable("id") String id, @RequestParam("areaCode") String areaCode){
        Map<String,Object> map = new HashMap<String,Object>();
        ModelAndView mav = new ModelAndView("mainWeather");
        try{
            map = mainService.getCurrentWeather(areaCode);
            mav.addObject("temperMap",map);
            mav.setViewName("mainWeather");
        }catch (AppException app){

        }catch (SysException sys){

        }
        return mav;
    }


}

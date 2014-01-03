package com.online.task.controller;

import com.online.common.exception.AppException;
import com.online.common.exception.SysException;
import com.online.common.model.Task;
import com.online.task.service.ITaskService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-11-25
 * Time: 下午5:25
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/task")
public class TaskController {

    private static Logger logger = Logger.getLogger(TaskController.class);

    @Autowired
    private ITaskService taskService;

    public ITaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(ITaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value="/{id}/taskMain")
    public String taskMain(@PathVariable("id") String id, HttpServletRequest request,
                           HttpServletResponse response) {
        return "task/taskMain";
    }

    @RequestMapping(value="/{id}/addTask")
    public String gotoAddTask(@PathVariable("id") String id){
        return "task/addTask";
    }
    @RequestMapping(value="/{id}/submitTask")
    @ResponseBody
    public Map<String,Object> addTask(@PathVariable("id") String id, HttpServletRequest request,
                          HttpServletResponse response){
        //add some comments
        return null;
    }

    @RequestMapping(value="/{id}/getAllTask")
    public String getAllTaskForUser(@PathVariable("id") String id, HttpServletRequest request,
                                    HttpServletResponse response){

        return "";
    }

    @ResponseBody
    @RequestMapping(value="/{id}/queryUnderTask",method= RequestMethod.GET, produces="application/json")
    public Map queryUnderTask(@PathVariable("id") String id) {
        Map<String, Object> results = new HashMap<String,Object>();
        try{
            List<Task> list = taskService.getUnderTaskByUserCode(id);
            results.put("underTasks",list) ;
        }catch (AppException app){
            results.put("underTasks",null);
            results.put("errorMsg","应用获取待完成任务列表异常");
        }catch (SysException sys){
            results.put("underTasks",null);
            results.put("errorMsg","应用获取待完成任务列表异常");
        }
        return results;
    }
}



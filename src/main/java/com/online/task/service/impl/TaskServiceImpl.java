package com.online.task.service.impl;

import com.online.common.Constant;
import com.online.common.exception.AppException;
import com.online.common.exception.SysException;
import com.online.common.model.Task;
import com.online.mapper.TaskMapper;
import com.online.task.service.ITaskService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-11-25
 * Time: 下午5:22
 * To change this template use File | Settings | File Templates.
 */
@Service(value="taskService")
public class TaskServiceImpl implements ITaskService{
    private static Logger logger = Logger.getLogger(TaskServiceImpl.class);

    @Autowired
    private TaskMapper taskMapper;

    public TaskMapper getTaskMapper() {
        return taskMapper;
    }

    public void setTaskMapper(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public List<Task> getAllTaskById(Map<String, Object> parameterMap)
        throws AppException, SysException {
        List<Task> results = null;
        try{
            results = taskMapper.getAllMyTask(parameterMap);
        }catch (DataAccessException sql){
             throw new SysException(10000,"数据层异常",sql);
        }catch (NullPointerException pointer){
            throw  new AppException(20000,"系统空指针异常",pointer);
        }catch (Exception e){
            throw new SysException(99999,"未知层面异常",e);
        }
        return results;
    }

    public List<Task> getUnderTaskByUserCode(String userCode)
        throws AppException, SysException{
       Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("userCode",userCode);
        parameterMap.put("completeStatus", Constant.COMPLETE_STATUS_COMPLETED.toString());

        List<Task> results = null;
        try{
             results = taskMapper.getUnderTaskByUserCode(parameterMap);
        }catch (DataAccessException sql){
            throw  new SysException(10000,"数据层异常",sql);
        }catch (NullPointerException pointer){
            throw new AppException(20000,"系统异常",pointer);
        }catch (Exception e){
            throw new SysException(99999,"未知层面异常",e);
        }
        return results;
    }

    public void saveTask(Task task)
        throws  AppException, SysException {

    }

}

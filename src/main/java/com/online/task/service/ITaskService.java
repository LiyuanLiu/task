package com.online.task.service;

import com.online.common.exception.AppException;
import com.online.common.exception.SysException;
import com.online.common.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-11-25
 * Time: 下午5:22
 * To change this template use File | Settings | File Templates.
 */
@Service
public interface ITaskService {
    public List<Task> getUnderTaskByUserCode(String userCode)
            throws AppException, SysException  ;
}

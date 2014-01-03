package com.online.mapper;

import com.online.common.exception.AppException;
import com.online.common.model.Task;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-11-25
 * Time: 下午2:44
 * To change this template use File | Settings | File Templates.
 */
public interface TaskMapper {

    public List<Task> getAllMyTask(Map<String, Object> parameterMap) throws DataAccessException;

    public List<Task> getUnderTaskByUserCode(Map<String, Object> parameterMap) throws  DataAccessException;
}

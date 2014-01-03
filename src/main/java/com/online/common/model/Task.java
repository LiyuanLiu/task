package com.online.common.model;

import com.online.common.Constant;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-11-25
 * Time: 下午2:30
 * To change this template use File | Settings | File Templates.
 */
public class Task implements Serializable{
    private long id;

    private String taskCode;

    private String createUser;

    private String taskName;

    private Date startTime;

    private Date endTime;

    private String priority;

    private String taskType;

    private Integer completeStatus;

    private Integer completePercent;

    private Integer totalPercent;

    private Date createDate;

    private String taskContent;

    private String taskTitle;

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Integer getCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(Integer completeStatus) {
        this.completeStatus = completeStatus;
    }

    public Integer getCompletePercent() {
        return completePercent;
    }

    public void setCompletePercent(Integer completePercent) {
        this.completePercent = completePercent;
    }

    public Integer getTotalPercent() {
        return totalPercent;
    }

    public void setTotalPercent(Integer totalPercent) {
        this.totalPercent = totalPercent;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public boolean equals(Object obj) {
        Task task = (Task) obj;
        if(this.getTaskCode().equals(task.getTaskCode()))
            return true;
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Task Detail:").
                append(this.getId())
                .append(this.getTaskCode())
                .append(this.getCreateUser())
                .append(this.getTaskName());
        if(Constant.COMPLETE_STATUS_READY == this.getCompleteStatus()){
            sb.append("状态就绪");
        }else if(Constant.COMPLETE_STATUS_PROCESSING == this.completeStatus){
            sb.append("正在进行中");
        }else if(Constant.COMPLETE_STATUS_COMPLETED == this.getCompleteStatus()){
            sb.append("任务已完成");
        }else{
            sb.append("未知任务状态");
        }
        sb.append(this.getCompletePercent()+"%");
        return sb.toString();
    }
}

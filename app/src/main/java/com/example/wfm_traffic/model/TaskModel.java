package com.example.wfm_traffic.model;

public class TaskModel {
    private String task;

    private int taskId;
    private String taskTitle;
    private String taskCategory;
    private String taskAssignedTo;
    private String taskDate;
    private String taskFrom;
    private String taskTo;

    public TaskModel(int taskId, String taskTitle, String taskCategory, String taskAssignedTo, String taskDate, String taskFrom, String taskTo) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskCategory = taskCategory;
        this.taskAssignedTo = taskAssignedTo;
        this.taskDate = taskDate;
        this.taskFrom = taskFrom;
        this.taskTo = taskTo;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(String taskCategory) {
        this.taskCategory = taskCategory;
    }

    public String getTaskAssignedTo() {
        return taskAssignedTo;
    }

    public void setTaskAssignedTo(String taskAssignedTo) {
        this.taskAssignedTo = taskAssignedTo;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskFrom() {
        return taskFrom;
    }

    public void setTaskFrom(String taskFrom) {
        this.taskFrom = taskFrom;
    }

    public String getTaskTo() {
        return taskTo;
    }

    public void setTaskTo(String taskTo) {
        this.taskTo = taskTo;
    }
}

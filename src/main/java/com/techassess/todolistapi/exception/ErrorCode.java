package com.techassess.todolistapi.exception;

public enum ErrorCode {
    USER_ID_NOT_FOUND("UserId was not found!"),
    TASK_NOT_FOUND("Task was not found!"),
    DELETE_FAILED("Deleting task was failed!");

    private final String message;

    ErrorCode(String message){this.message = message;}

    public String getMessage(){
        return message;
    }

}

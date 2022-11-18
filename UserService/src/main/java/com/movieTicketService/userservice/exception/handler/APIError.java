package com.movieTicketService.userservice.exception.handler;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.Map;

public class APIError {

    private String message;
    private String path;
    private Date timeStamp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, String> errorMap;

    public APIError() {
    }

    public APIError(String message, String path) {
        this.message = message;
        this.path = path;
        this.timeStamp = new Date();
    }

    public APIError(String message, String path, Map<String, String> errorMap) {
        this.message = message;
        this.path = path;
        this.timeStamp = new Date();
        this.errorMap = errorMap;
    }

    @Override
    public String toString() {
        return "APIError{" +
                "message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", timeStamp=" + timeStamp +
                ", errorMap=" + errorMap +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }
}

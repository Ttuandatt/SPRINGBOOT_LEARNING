package com.luv2code.demo.rest;

public class StudentErrorResponse {

    //Define fields
    private int status;
    private String message;
    private long timestamp;


    //Define constructors
    public StudentErrorResponse() {}

    public StudentErrorResponse(final int status, final String message, final long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    //Generate getter, setter


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

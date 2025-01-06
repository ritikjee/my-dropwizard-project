package com.shubhampriya1.assignment.dto;

public class ResponseDTO {
    private int status;
    private String message;

    public ResponseDTO(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseDTO() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

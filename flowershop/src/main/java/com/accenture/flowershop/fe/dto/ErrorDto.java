package com.accenture.flowershop.fe.dto;

import java.io.Serializable;

public class ErrorDto implements Serializable {

    private String message;

    public ErrorDto(String message)
    {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

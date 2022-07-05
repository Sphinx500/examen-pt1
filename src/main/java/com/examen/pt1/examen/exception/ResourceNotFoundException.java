package com.examen.pt1.examen.exception;


import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException {
    private final static long serialVersionUID = 1L;

    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable throwable){
        super(message,throwable);
    }
}

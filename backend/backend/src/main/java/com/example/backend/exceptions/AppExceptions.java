package com.example.backend.exceptions;

import org.springframework.http.HttpStatus;

public class AppExceptions extends RuntimeException {

    private final HttpStatus httpStatus;

    public AppExceptions(String message , HttpStatus httpStatus) {

        super(message);
        this.httpStatus = httpStatus;

    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}

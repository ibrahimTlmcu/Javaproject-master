package com.example.backend.config;

import com.example.backend.dto.ErrorDto;
import com.example.backend.exceptions.AppExceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = {AppExceptions.class})
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(AppExceptions ex) {
        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(new ErrorDto(ex.getMessage()));
    }
}

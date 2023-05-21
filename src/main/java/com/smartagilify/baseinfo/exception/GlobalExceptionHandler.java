package com.smartagilify.baseinfo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BaseInfoNotFoundException.class, BaseInfoDetailNotFoundException.class})
    public final ResponseEntity<Object> baseInfoNotFoundHandler(Exception ex, WebRequest req) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                req.getDescription(false));
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

}

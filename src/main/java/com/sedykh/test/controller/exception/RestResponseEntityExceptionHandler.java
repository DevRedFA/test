package com.sedykh.test.controller.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String MESSAGE_TO_USER = "Oops, something went wrong. For more details see the log.";

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class, NullPointerException.class})
    protected ResponseEntity<Object> handleIllegal(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, MESSAGE_TO_USER,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {SecurityException.class, UnsupportedOperationException.class})
    protected ResponseEntity<Object> handleSecurity(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, "Access denied.",
                new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleUnspecified(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, MESSAGE_TO_USER,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
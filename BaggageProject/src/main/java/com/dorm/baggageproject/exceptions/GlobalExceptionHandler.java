package com.dorm.baggageproject.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), ex.getMessage(), LocalDateTime.now(), request.getRequestURI());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BaggageException.class)
    public ResponseEntity<ErrorResponse> handleBaggageException(BaggageException ex, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), LocalDateTime.now(), request.getRequestURI());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
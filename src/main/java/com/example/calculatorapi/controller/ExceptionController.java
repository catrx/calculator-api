package com.example.calculatorapi.controller;

import com.example.calculatorapi.dto.ErrorDto;
import com.example.calculatorapi.exception.CalculateErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = CalculateErrorException.class)
    public ResponseEntity<ErrorDto> exception(CalculateErrorException exception) {
        ErrorDto error = new ErrorDto();
        error.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

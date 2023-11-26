package com.example.calculatorapi.exception;

public class CalculateErrorException extends Exception {
    private static final String DEFAULT_MESSAGE = "error.calculate";

    public CalculateErrorException() {
        super(DEFAULT_MESSAGE);
    }

    public CalculateErrorException(String message) {
        super(message);
    }


}
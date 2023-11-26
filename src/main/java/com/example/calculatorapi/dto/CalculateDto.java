package com.example.calculatorapi.dto;

public class CalculateDto {
    private Double firstValue;
    private String operator;
    private Double secondValue;

    public CalculateDto(Double firstValue, String operator, Double secondValue) {
        this.firstValue = firstValue;
        this.operator = operator;
        this.secondValue = secondValue;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Double getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(Double firstValue) {
        this.firstValue = firstValue;
    }

    public Double getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(Double secondValue) {
        this.secondValue = secondValue;
    }
}

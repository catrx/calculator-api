package com.example.calculatorapi.service;

import com.example.calculatorapi.dto.CalculateDto;
import com.example.calculatorapi.enums.Operator;
import com.example.calculatorapi.exception.CalculateErrorException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public String calculate(CalculateDto calculateDto) throws CalculateErrorException {
        Double firstValue = calculateDto.getFirstValue();
        String operator = calculateDto.getOperator();
        Double secondValue = calculateDto.getSecondValue();

        if (firstValue == null || operator == null || secondValue == null) {
            throw new CalculateErrorException("error.invalidInout");
        }

        switch (Operator.fromSymbol(operator)) {
            case ADDITION:
                return String.valueOf(firstValue + secondValue);
            case SUBTRACTION:
                return String.valueOf(firstValue - secondValue);
            case MULTIPLICATION:
                return String.valueOf(firstValue * secondValue);
            case DIVISION:
                if (secondValue != 0) {
                    return String.valueOf(firstValue / secondValue);
                } else {
                    throw new CalculateErrorException("error.dividedByZero");
                }
            default:
                throw new CalculateErrorException("error.operatorNotValid");
        }
    }
}

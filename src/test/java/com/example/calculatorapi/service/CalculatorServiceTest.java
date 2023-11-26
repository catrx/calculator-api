package com.example.calculatorapi.service;

import com.example.calculatorapi.dto.CalculateDto;
import com.example.calculatorapi.enums.Operator;
import com.example.calculatorapi.exception.CalculateErrorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceTest {
    @Test
    public void testCalculate_Addition() throws CalculateErrorException {
        CalculateDto calculateDto = new CalculateDto(2.0, Operator.ADDITION.getSymbol(), 3.0);
        CalculatorService calculatorService = new CalculatorService();

        String result = calculatorService.calculate(calculateDto);

        assertEquals("5.0", result);
    }

    @Test
    public void testCalculate_Subtraction() throws CalculateErrorException {
        CalculateDto calculateDto = new CalculateDto(5.0, Operator.SUBTRACTION.getSymbol(), 3.0);
        CalculatorService calculatorService = new CalculatorService();

        String result = calculatorService.calculate(calculateDto);

        assertEquals("2.0", result);
    }

    @Test
    public void testCalculate_Multiplication() throws CalculateErrorException {
        CalculateDto calculateDto = new CalculateDto(2.0, Operator.MULTIPLICATION.getSymbol(), 3.0);
        CalculatorService calculatorService = new CalculatorService();

        String result = calculatorService.calculate(calculateDto);

        assertEquals("6.0", result);
    }

    @Test
    public void testCalculate_Division() throws CalculateErrorException {
        CalculateDto calculateDto = new CalculateDto(6.0, Operator.DIVISION.getSymbol(), 2.0);
        CalculatorService calculatorService = new CalculatorService();

        String result = calculatorService.calculate(calculateDto);

        assertEquals("3.0", result);
    }

    @Test
    public void testCalculate_DivisionByZero() {
        CalculateDto calculateDto = new CalculateDto(5.0, Operator.DIVISION.getSymbol(), 0.0);
        CalculatorService calculatorService = new CalculatorService();

        assertThrows(CalculateErrorException.class, () -> calculatorService.calculate(calculateDto), "error.dividedByZero");
    }

    @Test
    public void testCalculate_InvalidInput_NullOperator() {
        CalculateDto calculateDto = new CalculateDto(2.0, null, 3.0);
        CalculatorService calculatorService = new CalculatorService();

        assertThrows(CalculateErrorException.class, () -> calculatorService.calculate(calculateDto), "error.operatorNotValid");
    }

    @Test
    public void testCalculate_InvalidInput_NullValues() {
        CalculateDto calculateDto = new CalculateDto(null, Operator.ADDITION.getSymbol(), null);
        CalculatorService calculatorService = new CalculatorService();

        assertThrows(CalculateErrorException.class, () -> calculatorService.calculate(calculateDto), "error.invalidInout");
    }
}

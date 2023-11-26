package com.example.calculatorapi.controller;

import com.example.calculatorapi.dto.CalculateDto;
import com.example.calculatorapi.exception.CalculateErrorException;
import com.example.calculatorapi.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String Calculator(@RequestBody CalculateDto calculateDto) throws CalculateErrorException {
        return calculatorService.calculate(calculateDto);
    }
}

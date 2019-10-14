 package com.airwallex.shell;

 import org.springframework.shell.standard.ShellMethod;

import com.airwallex.service.CalculatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.shell.standard.ShellComponent;

@ShellComponent
public class Command {

    @Lazy
    @Autowired
    private CalculatorService calculatorService;

    @ShellMethod(value = "RPN Calculator", key = ParsedLineInput.METHOD)
    public void calc(String  inputs) {
        calculatorService.process(inputs);
    }
}
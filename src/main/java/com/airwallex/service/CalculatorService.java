package com.airwallex.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Service;

import com.airwallex.operation.*;

@Service
public class CalculatorService {
    private final int  PRECISION = 10;

    private int position;
    private List<Processor> processors;
    private Stack<Double> parameters;
    private Stack<Stack<Double>> history;

    public CalculatorService() {
        position = 1;

        processors = new ArrayList<>();
        parameters = new Stack<>();
        history = new Stack<>();

        processors.add(new AdditionProcessor());
        processors.add(new SubtractionProcessor());
        processors.add(new MultiplicationProcessor());
        processors.add(new DivisionProcessor());
        processors.add(new SqrtProcessor());
        processors.add(new NumberProcessor());
        processors.add(new ClearProcessor());
        processors.add(new DebugProcessor());
        processors.add(new UndoProcessor());
        processors.add(new QuitProcessor());
    }

    public void process(String inputs) {
        position = 1;
        String[] inputArray = inputs.toLowerCase().split(" ");
        for (int i = 0; i < inputArray.length; i++) {
            String input = inputArray[i];
            if (processItem(input)) {
                position += (input.length() + 1);
            } else {
                break;
            }
        }

        showResult();
    }

    private boolean processItem(String input) {
        for (Processor processor : processors) {
            if (processor.accept(input, parameters)) {
                return processor.process(position, parameters, history);
            }
        }

        System.out.println("operator * (position: " + position + "): invalid parameter");

        return false;
    }

    private void showResult() {
        System.out.print("stack: ");
        parameters.forEach(number -> {
            BigDecimal bd = new BigDecimal(number);
            number = bd.setScale(PRECISION, BigDecimal.ROUND_DOWN).doubleValue();

            if (number % 1.0 == 0) {
                System.out.print(number.intValue());
            } else {
                System.out.print(number);
            }

            System.out.print(" ");
        });
        System.out.println();
    }

    // For unit test only
    public Stack<Double> getParameters() {
        return parameters;
    }

}
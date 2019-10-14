package com.airwallex.operation;

public class MultiplicationProcessor extends TwoElementsProcessor {

    public MultiplicationProcessor() {
        operator = "*";
    }

    @Override
    protected double process(Double element1, Double element2) throws Exception {
        return element1 * element2;
    }

}
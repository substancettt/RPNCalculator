package com.airwallex.operation;

public class DivisionProcessor extends TwoElementsProcessor {

    public DivisionProcessor() {
        operator = "/";
    }

    @Override
    protected double process(Double element1, Double element2) throws Exception {
        if (element2.equals(Double.valueOf(0.0))) {
            throw new Exception("invalid divisor");
        }
        return element1 / element2;
    }

}
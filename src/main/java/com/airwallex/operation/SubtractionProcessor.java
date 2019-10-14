package com.airwallex.operation;

public class SubtractionProcessor extends TwoElementsProcessor {

    public SubtractionProcessor() {
        operator = "-";
    }

    @Override
    protected double process(Double element1, Double element2) throws Exception {
        return element1 - element2;
    }

}
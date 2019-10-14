package com.airwallex.operation;

public class SqrtProcessor  extends OneElementProcessor {

    public SqrtProcessor() {
        operator = "sqrt";
    }

    @Override
    protected double process(Double element) throws Exception {
        return  Math.sqrt(element);
    }

}
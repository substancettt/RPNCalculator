package com.airwallex.operation;

import java.util.Stack;

public abstract class BaseProcessor implements Processor {
    protected final int  PRECISION = 15;
    String operator;

    @Override
    public boolean accept(String input, Stack<Double> parameters) {
        return this.operator.equals(input);
    }

    @Override
    public boolean process(int position, Stack<Double> parameters, Stack<Stack<Double>> history) {
        return true;
    }

    protected void revert(Stack<Double> parameters, Stack<Stack<Double>> history) {
        parameters.clear();
        if (history.size()> 0 ) {
            for (Double number : history.pop()) {
                parameters.push(number);
            }
        }
    }
}
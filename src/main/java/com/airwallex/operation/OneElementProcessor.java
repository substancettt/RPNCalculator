package com.airwallex.operation;

import java.math.BigDecimal;
import java.util.Stack;

public abstract class OneElementProcessor extends BaseProcessor {
    protected abstract double process(Double element) throws Exception;

    @Override
    public boolean process(int position, Stack<Double> parameters, Stack<Stack<Double>> history) {
        if (parameters.size() > 0) {
            Stack<Double> stack = new Stack<>();

            for (Double number : parameters) {
                stack.push(number);
            }
            history.push(stack);

            try {
                parameters.push(new BigDecimal(process(parameters.pop())).setScale(PRECISION, BigDecimal.ROUND_DOWN).doubleValue());

                return true;
            } catch (Exception e) {
                System.out.println("operator * (position: " + position + "): " + e.getMessage());

                revert(parameters, history);
            }
        } else {
            System.out.println("operator * (position: " + position + "): insucient parameters");
        }

        return false;
    }

}
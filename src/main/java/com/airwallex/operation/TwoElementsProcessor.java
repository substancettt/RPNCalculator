package com.airwallex.operation;

import java.math.BigDecimal;
import java.util.Stack;

public abstract class TwoElementsProcessor extends BaseProcessor {
    protected abstract double process(Double element1, Double element2) throws Exception;

    @Override
    public boolean process(int position, Stack<Double> parameters, Stack<Stack<Double>> history) {
        if (parameters.size() > 1) {
            Stack<Double> stack = new Stack<>();
            
            for (Double number : parameters) {
                stack.push(number);
            }
            history.push(stack);

            Double element2 = parameters.pop();
            Double element1 = parameters.pop();

            try {
                parameters.push(new BigDecimal(process(element1, element2)).setScale(PRECISION, BigDecimal.ROUND_DOWN).doubleValue());

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
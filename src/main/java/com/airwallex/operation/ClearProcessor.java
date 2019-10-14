package com.airwallex.operation;

import java.util.Stack;

public class ClearProcessor extends BaseProcessor {

    public ClearProcessor() {
        operator = "clear";
    }

    @Override
    public boolean process(int position, Stack<Double> parameters, Stack<Stack<Double>> history) {
        parameters.clear();
        history.clear();

        return true;
    }

}
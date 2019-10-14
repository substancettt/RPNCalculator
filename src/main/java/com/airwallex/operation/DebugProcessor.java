package com.airwallex.operation;

import java.util.Stack;

public class DebugProcessor extends BaseProcessor {

    public DebugProcessor() {
        operator = "debug";
    }

    @Override
    public boolean process(int position, Stack<Double> parameters, Stack<Stack<Double>> history) {
        System.out.println(parameters);
        System.out.println(history);

        return true;
    }

}
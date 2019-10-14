package com.airwallex.operation;

import java.util.Stack;

public class UndoProcessor extends BaseProcessor {

    public UndoProcessor() {
        operator = "undo";
    }

    @Override
    public boolean process(int position, Stack<Double> parameters, Stack<Stack<Double>> history) {
        revert(parameters, history);

        return true;
    }

}
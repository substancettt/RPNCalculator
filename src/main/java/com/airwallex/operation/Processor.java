package com.airwallex.operation;

import java.util.Stack;

public interface Processor {
    boolean accept(String operator, Stack<Double> parameters);
    boolean process(int position, Stack<Double> parameters, Stack<Stack<Double>> history);
}
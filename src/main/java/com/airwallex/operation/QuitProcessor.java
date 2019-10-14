package com.airwallex.operation;

import java.util.Stack;

import org.springframework.shell.ExitRequest;

public class QuitProcessor extends BaseProcessor {

    @Override
    public boolean accept(String input, Stack<Double> parameters) {
        return input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit");
    }

    @Override
    public boolean process(int position, Stack<Double> parameters, Stack<Stack<Double>> history) {
        System.out.println("type one more time to exit");
        throw new ExitRequest(0);
    }

}

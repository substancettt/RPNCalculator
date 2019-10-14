package com.airwallex.operation;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberProcessor extends BaseProcessor {
    private final static String REGEX_NUMBER = "^[-\\+]?(\\d+|\\d+\\.\\d+)$";

    @Override
    public boolean accept(String input, Stack<Double> parameters) {        
        if (isMatch(REGEX_NUMBER, input)) {
            Double number;
            if (input.contains(".")) {
                number = Double.valueOf(input);
            } else {
                number = Double.valueOf(input + ".0");
            }

            parameters.push(number);
            return true;
        }

        return false;
    }

    @Override
    public boolean process(int position, Stack<Double> parameters, Stack<Stack<Double>> history) {
            Stack<Double> stack = new Stack<>();

            for (Double number : parameters) {
                stack.push(number);
            }

            if (stack.size() > 0) {
                stack.pop();
            }

            history.push(stack);

            return true;
    }

    private boolean isMatch(String regex, String orginal) {
        if (orginal == null || orginal.trim().equals("")) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher isNum = pattern.matcher(orginal);
        return isNum.matches();
    }

}
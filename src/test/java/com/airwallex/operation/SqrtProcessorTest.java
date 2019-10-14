package com.airwallex.operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class SqrtProcessorTest {
    Processor sqrtProcessor = new SqrtProcessor();
    Stack<Stack<Double>> history = new Stack<>();

    @Test
    public void test1() {
        Stack<Double> parameters = new Stack<>();

        history.clear();
        parameters.push(81.0);

        assertFalse(sqrtProcessor.accept("abc", parameters));
        assertTrue(sqrtProcessor.accept("sqrt", parameters));
        assertTrue(sqrtProcessor.process(0, parameters, history));
        assertEquals(1, parameters.size(), 0.0);
        assertEquals(9.0, parameters.pop(), 0.0);
        assertEquals(1, history.size(), 0.0);
    }

    @Test
    public void test2() {
        Stack<Double> parameters = new Stack<>();

        history.clear();
        assertFalse(sqrtProcessor.process(0, parameters, history));

        assertEquals(0, parameters.size(), 0.0);
        assertEquals(0, history.size(), 0.0);
    }

}
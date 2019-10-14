package com.airwallex.operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class NumberProcessorTest {
    Processor numberProcessor = new NumberProcessor();
    Stack<Stack<Double>> history = new Stack<>();

    @Test
    public void test1() {
        Stack<Double> parameters = new Stack<>();

        history.clear();
        assertTrue(numberProcessor.accept("2", parameters));
        assertTrue(numberProcessor.process(0, parameters, history));
        assertEquals(1, parameters.size(), 0.0);
        assertEquals(2.0, parameters.pop(), 0.0);
        assertEquals(1, history.size(), 0.0);
    }

    @Test
    public void test2() {
        Stack<Double> parameters = new Stack<>();

        history.clear();
        assertTrue(numberProcessor.accept("27.333", parameters));
        assertTrue(numberProcessor.process(0, parameters, history));
        assertEquals(1, parameters.size(), 0.0);
        assertEquals(27.333, parameters.pop(), 0.0);
        assertEquals(1, history.size(), 0.0);
    }

    @Test
    public void test3() {
        Stack<Double> parameters = new Stack<>();

        history.clear();
        assertFalse(numberProcessor.accept("abc", parameters));
        assertEquals(0, parameters.size(), 0.0);
        assertEquals(0, history.size(), 0.0);
    }

    @Test
    public void test4() {
        Stack<Double> parameters = new Stack<>();

        history.clear();
        assertFalse(numberProcessor.accept("20.", parameters));
        assertEquals(0, parameters.size(), 0.0);
        assertEquals(0, history.size(), 0.0);
    }

    @Test
    public void test5() {
        Stack<Double> parameters = new Stack<>();

        history.clear();
        assertFalse(numberProcessor.accept("1.2.3", parameters));
        assertEquals(0, parameters.size(), 0.0);
        assertEquals(0, history.size(), 0.0);
    }
}
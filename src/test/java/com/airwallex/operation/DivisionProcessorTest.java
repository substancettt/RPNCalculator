package com.airwallex.operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class DivisionProcessorTest {
    Processor divisionProcessor = new DivisionProcessor();
    Stack<Stack<Double>> history = new Stack<>();

    @Test
    public void test1() {
        Stack<Double> parameters = new Stack<>();
        
        history.clear();
        parameters.push(27.0);
        parameters.push(3.0);

        assertFalse(divisionProcessor.accept("+", parameters));
        assertTrue(divisionProcessor.accept("/", parameters));
        assertTrue(divisionProcessor.process(0, parameters, history));
        assertEquals(1, parameters.size(), 0.0);
        assertEquals(9.0, parameters.pop(), 0.0);
        assertEquals(1, history.size(), 0.0);
    }

    @Test
    public void test2() {
        Stack<Double> parameters = new Stack<>();

        history.clear();
        parameters.push(2.0);
        
        assertFalse(divisionProcessor.process(0, parameters, history));
        assertEquals(1, parameters.size(), 0.0);
        assertEquals(2.0, parameters.pop(), 0.0);
        assertEquals(0, history.size(), 0.0);
    }

    @Test
    public void test3() {
        Stack<Double> parameters = new Stack<>();

        history.clear();
        parameters.push(6.0);
        parameters.push(0.0);

        assertFalse(divisionProcessor.process(0, parameters, history));
        assertEquals(2, parameters.size(), 0);
        assertEquals(0.0, parameters.pop(), 0.0);
        assertEquals(6.0, parameters.pop(), 0.0);
        assertEquals(0, history.size(), 0.0);
    }
}
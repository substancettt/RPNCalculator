package com.airwallex.operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class MultiplicationProcessorTest {
    Processor multiplicationProcessor = new MultiplicationProcessor();
    Stack<Stack<Double>> history = new Stack<>();

    @Test
    public void test() {
        Stack<Double> parameters = new Stack<>();
        
        history.clear();
        parameters.push(9.0);
        parameters.push(3.0);

        assertFalse(multiplicationProcessor.accept("+", parameters));
        assertTrue(multiplicationProcessor.accept("*", parameters));
        assertTrue(multiplicationProcessor.process(0, parameters, history));
        assertEquals(1, parameters.size(), 0.0);
        assertEquals(27.0, parameters.pop(), 0.0);
        assertEquals(1, history.size(), 0.0);
    }

}
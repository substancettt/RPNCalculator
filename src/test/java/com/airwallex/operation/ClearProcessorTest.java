package com.airwallex.operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class ClearProcessorTest {
    Processor clearProcessor = new ClearProcessor();
    Stack<Stack<Double>> history = new Stack<>();

    @Test
    public void test() {
        Stack<Double> parameters = new Stack<>();
        
        history.clear();
        parameters.push(27.0);
        parameters.push(3.0);

        assertEquals(2, parameters.size(), 0.0);
        assertFalse(clearProcessor.accept("abc", parameters));
        assertTrue(clearProcessor.accept("clear", parameters));
        assertTrue(clearProcessor.process(0, parameters, history));
        assertEquals(0, parameters.size(), 0.0);
        assertEquals(0, history.size(), 0.0);
    }

}
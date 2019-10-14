package com.airwallex.operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class AdditionProcessorTest {
    Processor additionProcessor = new AdditionProcessor();
    Stack<Stack<Double>> history = new Stack<>();

    @Test
    public void test() {
        Stack<Double> parameters = new Stack<>();
        
        history.clear();
        parameters.push(27.0);
        parameters.push(3.0);

        assertFalse(additionProcessor.accept("%", parameters));
        assertTrue(additionProcessor.accept("+", parameters));
        assertTrue(additionProcessor.process(0, parameters, history));
        assertEquals(1, parameters.size(), 0.0);
        assertEquals(30.0, parameters.pop(), 0.0);
        assertEquals(1, history.size(), 0.0);
    }

}
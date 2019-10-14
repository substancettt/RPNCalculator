package com.airwallex.operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class UndoProcessorTest {
    Processor undoProcessor = new UndoProcessor();
    Stack<Stack<Double>> history = new Stack<>();

    @Test
    public void test1() {
        Stack<Double> parameters = new Stack<>();
        
        history.clear();
        parameters.push(27.0);

        assertEquals(1, parameters.size(), 0.0);
        assertFalse(undoProcessor.accept("abc", parameters));
        assertTrue(undoProcessor.accept("undo", parameters));
        assertTrue(undoProcessor.process(0, parameters, history));
        assertEquals(0, parameters.size(), 0.0);
        assertEquals(0, history.size(), 0.0);
    }

}
package com.airwallex.operation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class QuitProcessorTest {
    Processor quitProcessor = new QuitProcessor();
    Stack<Stack<Double>> history = new Stack<>();

    @Test
    public void test1() {
        assertFalse(quitProcessor.accept("abc", null));
        assertTrue(quitProcessor.accept("quit", null));
    }

}
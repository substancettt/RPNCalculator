package com.airwallex.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Stack;

import org.junit.Test;

public class CalculatorServiceTest {
    private CalculatorService calculatorService = new CalculatorService();

	@Test
	public void test1() {
        Stack<Double> parameters = calculatorService.getParameters();
        
        parameters.clear();
        calculatorService.process("5 2");

        assertEquals(2, parameters.size(), 0);
        assertEquals(2, parameters.pop(), 0);
        assertEquals(5, parameters.pop(), 0);
    }
    
    @Test
	public void test2() {
        Stack<Double> parameters = calculatorService.getParameters();

        parameters.clear();
        calculatorService.process("2 sqrt");

        assertEquals(1, parameters.size(), 0);
        assertEquals(1.4142135623, new BigDecimal(parameters.lastElement()).setScale(10, BigDecimal.ROUND_DOWN).doubleValue() , 0);

        calculatorService.process("clear 9 sqrt");

        assertEquals(1, parameters.size(), 0);
        assertEquals(3, parameters.lastElement(), 0);
    }
    
    @Test
	public void test3() {
        Stack<Double> parameters = calculatorService.getParameters();
        
        parameters.clear();
        calculatorService.process("5 2 -");

        assertEquals(1, parameters.size(), 0);
        assertEquals(3, parameters.lastElement(), 0);

        calculatorService.process("3 -");

        assertEquals(1, parameters.size(), 0);
        assertEquals(0, parameters.lastElement(), 0);

        calculatorService.process("clear");

        assertEquals(0, parameters.size(), 0);
    }
    
    @Test
	public void test4() {
        Stack<Double> parameters = calculatorService.getParameters();
        
        parameters.clear();
        calculatorService.process("5 4 3 2");

        assertEquals(4, parameters.size(), 0);
        assertEquals(2, parameters.lastElement(), 0);
        assertEquals(5, parameters.firstElement() , 0);

        calculatorService.process("undo undo *");

        assertEquals(1, parameters.size(), 0);
        assertEquals(20, parameters.lastElement(), 0);

        calculatorService.process("5 *");

        assertEquals(1, parameters.size(), 0);
        assertEquals(100, parameters.lastElement(), 0);

        calculatorService.process("undo");

        assertEquals(2, parameters.size(), 0);
        assertEquals(5, parameters.lastElement(), 0);
        assertEquals(20, parameters.firstElement() , 0);
    }
    
    @Test
	public void test5() {
        Stack<Double> parameters = calculatorService.getParameters();
        
        parameters.clear();
        calculatorService.process("7 12 2 /");

        assertEquals(2, parameters.size(), 0);
        assertEquals(6, parameters.lastElement(), 0);
        assertEquals(7, parameters.firstElement() , 0);

        calculatorService.process("*");

        assertEquals(1, parameters.size(), 0);
        assertEquals(42, parameters.lastElement(), 0);

        calculatorService.process("4 /");

        assertEquals(1, parameters.size(), 0);
        assertEquals(10.5, parameters.lastElement(), 0);
    }
    
    @Test
	public void test6() {
        Stack<Double> parameters = calculatorService.getParameters();
        
        parameters.clear();
        calculatorService.process("1 2 3 4 5");

        assertEquals(5, parameters.size(), 0);
        assertEquals(5, parameters.lastElement(), 0);
        assertEquals(1, parameters.firstElement() , 0);

        calculatorService.process("*");

        assertEquals(4, parameters.size(), 0);
        assertEquals(20, parameters.lastElement(), 0);
        assertEquals(1, parameters.firstElement() , 0);

        calculatorService.process("clear 3 4 -");

        assertEquals(1, parameters.size(), 0);
        assertEquals(-1, parameters.lastElement(), 0);
    }
    
    @Test
	public void test7() {
        Stack<Double> parameters = calculatorService.getParameters();
        
        parameters.clear();
        calculatorService.process("1 2 3 4 5");

        assertEquals(5, parameters.size(), 0);
        assertEquals(5, parameters.lastElement(), 0);
        assertEquals(1, parameters.firstElement() , 0);

        calculatorService.process("* * * *");

        assertEquals(1, parameters.size(), 0);
        assertEquals(120, parameters.lastElement(), 0);
    }

    @Test
	public void test8() {
        Stack<Double> parameters = calculatorService.getParameters();
        
        parameters.clear();
        calculatorService.process("1 2 3 * 5 + * * 6 5");

        assertEquals(1, parameters.size(), 0);
        assertEquals(11, parameters.lastElement(), 0);
    }

}

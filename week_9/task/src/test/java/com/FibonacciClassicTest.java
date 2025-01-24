package com;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FibonacciClassicTest {
    @Test
    public void testFibonacci() {
        assertEquals(0, FibonacciClassic.fibonacci(0));
        assertEquals(1, FibonacciClassic.fibonacci(1));
        assertEquals(1, FibonacciClassic.fibonacci(2));
        assertEquals(2, FibonacciClassic.fibonacci(3));
        assertEquals(3, FibonacciClassic.fibonacci(4));
        assertEquals(5, FibonacciClassic.fibonacci(5));
    }
}

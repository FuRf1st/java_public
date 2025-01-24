package com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class FibonacciMemoizedTest {
    @Test
    public void testFibonacci() {
        assertEquals(0, FibonacciMemoized.fibonacci(0));
        assertEquals(1, FibonacciMemoized.fibonacci(1));
        assertEquals(1, FibonacciMemoized.fibonacci(2));
        assertEquals(2, FibonacciMemoized.fibonacci(3));
        assertEquals(3, FibonacciMemoized.fibonacci(4));
        assertEquals(5, FibonacciMemoized.fibonacci(5));
    }

    @Test
    public void testMemoization() {
        FibonacciMemoized.fibonacci(10);
        assertTrue(FibonacciMemoized.getMemo().containsKey(10)); // Проверяем наличие
        assertEquals(55L, (long) FibonacciMemoized.getMemo().get(10)); // Проверяем значение
    }
}

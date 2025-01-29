package com;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GenericStackTest {

    @Test
    void testPushPop() {
        Stack<Integer> stack = new GenericStack<>();
        stack.push(10);
        stack.push(20);
        assertEquals(2, stack.size());
        assertEquals(20, stack.pop());
        assertEquals(1, stack.size());
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPeek() {
        Stack<String> stack = new GenericStack<>();
        stack.push("first");
        stack.push("second");
        assertEquals("second", stack.peek());
        stack.pop();
        assertEquals("first", stack.peek());
    }

    @Test
    void testIsEmpty() {
        Stack<Double> stack = new GenericStack<>();
        assertTrue(stack.isEmpty());
        stack.push(10.5);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPopEmptyStack() {
        Stack<Integer> stack = new GenericStack<>();
        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    void testPeekEmptyStack() {
        Stack<String> stack = new GenericStack<>();
        assertThrows(IllegalStateException.class, stack::peek);
    }
}


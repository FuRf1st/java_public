package com;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void testIntegerStack() {
        Stack<Integer> stack = new GenericStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(3, stack.size(), "Ошибка: размер стека не равен 3");
        assertEquals(30, stack.peek(), "Ошибка: верхний элемент стека не равен 30");
        assertEquals(30, stack.pop(), "Ошибка: извлечённый элемент не равен 30");
        assertEquals(20, stack.pop(), "Ошибка: извлечённый элемент не равен 20");
        assertEquals(10, stack.pop(), "Ошибка: извлечённый элемент не равен 10");
        assertTrue(stack.isEmpty(), "Ошибка: стек не пустой");
    }

    @Test
    public void testStringStack() {
        Stack<String> stack = new GenericStack<>();
        stack.push("Hello");
        stack.push("World");

        assertEquals(2, stack.size(), "Ошибка: размер стека не равен 2");
        assertEquals("World", stack.peek(), "Ошибка: верхний элемент стека не равен 'World'");
        assertEquals("World", stack.pop(), "Ошибка: извлечённый элемент не равен 'World'");
        assertEquals("Hello", stack.pop(), "Ошибка: извлечённый элемент не равен 'Hello'");
        assertTrue(stack.isEmpty(), "Ошибка: стек не пустой");
    }

    @Test
    public void testDoubleStack() {
        Stack<Double> stack = new GenericStack<>();
        stack.push(1.1);
        stack.push(2.2);
        stack.push(3.3);

        assertEquals(3, stack.size(), "Ошибка: размер стека не равен 3");
        assertEquals(3.3, stack.peek(), "Ошибка: верхний элемент стека не равен 3.3");
        assertEquals(3.3, stack.pop(), "Ошибка: извлечённый элемент не равен 3.3");
        assertEquals(2.2, stack.pop(), "Ошибка: извлечённый элемент не равен 2.2");
        assertEquals(1.1, stack.pop(), "Ошибка: извлечённый элемент не равен 1.1");
        assertTrue(stack.isEmpty(), "Ошибка: стек не пустой");
    }

    @Test
    public void testEdgeCases() {
        Stack<Integer> stack = new GenericStack<>();
        
        Exception exception = assertThrows(IllegalStateException.class, stack::pop);
        assertEquals("Стек пустой", exception.getMessage(), "Ошибка: неверное сообщение об ошибке при pop() из пустого стека");

        exception = assertThrows(IllegalStateException.class, stack::peek);
        assertEquals("Стек пустой", exception.getMessage(), "Ошибка: неверное сообщение об ошибке при peek() из пустого стека");

        stack.push(42);
        assertEquals(1, stack.size(), "Ошибка: размер стека не равен 1");
        assertEquals(42, stack.peek(), "Ошибка: верхний элемент стека не равен 42");
        assertEquals(42, stack.pop(), "Ошибка: извлечённый элемент не равен 42");
        assertTrue(stack.isEmpty(), "Ошибка: стек не пустой");
    }
}

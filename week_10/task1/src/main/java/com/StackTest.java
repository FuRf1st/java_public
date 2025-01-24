package com;

public class StackTest {
    public static void main(String[] args) {
        System.out.println("Тестирование стека с Integer...");
        testIntegerStack();

        System.out.println("\nТестирование стека с String...");
        testStringStack();

        System.out.println("\nТестирование стека с Double...");
        testDoubleStack();

        System.out.println("\nТестирование граничных случаев...");
        testEdgeCases();

        System.out.println("\nВсе тесты пройдены успешно!");
    }

    private static void testIntegerStack() {
        Stack<Integer> stack = new GenericStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Размер стека: " + stack.size());
        System.out.println("Верхний элемент: " + stack.peek());
        System.out.println("Извлечено: " + stack.pop());
        System.out.println("Извлечено: " + stack.pop());
        System.out.println("Извлечено: " + stack.pop());
        System.out.println("Стек пустой? " + stack.isEmpty());
    }

    private static void testStringStack() {
        Stack<String> stack = new GenericStack<>();
        stack.push("Hello");
        stack.push("World");

        System.out.println("Размер стека: " + stack.size());
        System.out.println("Верхний элемент: " + stack.peek());
        System.out.println("Извлечено: " + stack.pop());
        System.out.println("Извлечено: " + stack.pop());
        System.out.println("Стек пустой? " + stack.isEmpty());
    }

    private static void testDoubleStack() {
        Stack<Double> stack = new GenericStack<>();
        stack.push(1.1);
        stack.push(2.2);
        stack.push(3.3);

        System.out.println("Размер стека: " + stack.size());
        System.out.println("Верхний элемент: " + stack.peek());
        System.out.println("Извлечено: " + stack.pop());
        System.out.println("Извлечено: " + stack.pop());
        System.out.println("Извлечено: " + stack.pop());
        System.out.println("Стек пустой? " + stack.isEmpty());
    }

    private static void testEdgeCases() {
        Stack<Integer> stack = new GenericStack<>();
        try {
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Исключение при извлечении из пустого стека: " + e.getMessage());
        }

        try {
            stack.peek();
        } catch (IllegalStateException e) {
            System.out.println("Исключение при вызове peek на пустом стеке: " + e.getMessage());
        }

        stack.push(42);
        System.out.println("Добавлен элемент: 42");
        System.out.println("Размер стека: " + stack.size());
        System.out.println("Верхний элемент: " + stack.peek());
        System.out.println("Извлечено: " + stack.pop());
        System.out.println("Стек пустой? " + stack.isEmpty());
    }
}
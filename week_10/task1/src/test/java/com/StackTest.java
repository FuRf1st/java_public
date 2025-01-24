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

        assert stack.size() == 3 : "Ошибка: размер стека не равен 3";
        assert stack.peek() == 30 : "Ошибка: верхний элемент стека не равен 30";
        assert stack.pop() == 30 : "Ошибка: извлечённый элемент не равен 30";
        assert stack.pop() == 20 : "Ошибка: извлечённый элемент не равен 20";
        assert stack.pop() == 10 : "Ошибка: извлечённый элемент не равен 10";
        assert stack.isEmpty() : "Ошибка: стек не пустой";
    }

    private static void testStringStack() {
        Stack<String> stack = new GenericStack<>();
        stack.push("Hello");
        stack.push("World");

        assert stack.size() == 2 : "Ошибка: размер стека не равен 2";
        assert stack.peek().equals("World") : "Ошибка: верхний элемент стека не равен 'World'";
        assert stack.pop().equals("World") : "Ошибка: извлечённый элемент не равен 'World'";
        assert stack.pop().equals("Hello") : "Ошибка: извлечённый элемент не равен 'Hello'";
        assert stack.isEmpty() : "Ошибка: стек не пустой";
    }

    private static void testDoubleStack() {
        Stack<Double> stack = new GenericStack<>();
        stack.push(1.1);
        stack.push(2.2);
        stack.push(3.3);

        assert stack.size() == 3 : "Ошибка: размер стека не равен 3";
        assert stack.peek() == 3.3 : "Ошибка: верхний элемент стека не равен 3.3";
        assert stack.pop() == 3.3 : "Ошибка: извлечённый элемент не равен 3.3";
        assert stack.pop() == 2.2 : "Ошибка: извлечённый элемент не равен 2.2";
        assert stack.pop() == 1.1 : "Ошибка: извлечённый элемент не равен 1.1";
        assert stack.isEmpty() : "Ошибка: стек не пустой";
    }

    private static void testEdgeCases() {
        Stack<Integer> stack = new GenericStack<>();
        
        try {
            stack.pop();
        } catch (IllegalStateException e) {
            assert e.getMessage().equals("Стек пустой") : "Ошибка: неверное сообщение об ошибке при pop() из пустого стека";
        }

        try {
            stack.peek();
        } catch (IllegalStateException e) {
            assert e.getMessage().equals("Стек пустой") : "Ошибка: неверное сообщение об ошибке при peek() из пустого стека";
        }

        stack.push(42);
        assert stack.size() == 1 : "Ошибка: размер стека не равен 1";
        assert stack.peek() == 42 : "Ошибка: верхний элемент стека не равен 42";
        assert stack.pop() == 42 : "Ошибка: извлечённый элемент не равен 42";
        assert stack.isEmpty() : "Ошибка: стек не пустой";
    }
}

package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Стек для целых чисел
        Stack<Integer> stackInt = new GenericStack<>();
        stackInt.push(1);
        stackInt.push(2);
        System.out.println("Integer Stack:");
        while (!stackInt.isEmpty()) {
            System.out.println(stackInt.pop());
        }

        // Стек для чисел с плавающей точкой
        Stack<Double> stackDouble = new GenericStack<>();
        stackDouble.push(3.14);
        stackDouble.push(2.71);
        System.out.println("Double Stack:");
        while (!stackDouble.isEmpty()) {
            System.out.println(stackDouble.pop());
        }

        // Стек для строк
        Stack<String> stackString = new GenericStack<>();
        stackString.push("Hello");
        stackString.push("World");
        System.out.println("String Stack:");
        while (!stackString.isEmpty()) {
            System.out.println(stackString.pop());
        }

        // Ввод данных для стека Integer
        Stack<Integer> userStack = new GenericStack<>();
        System.out.println("Введите количество элементов для добавления в стек:");
        int n = scanner.nextInt();

        System.out.println("Введите " + n + " элементов (целые числа):");
        for (int i = 0; i < n; i++) {
            int element = scanner.nextInt();
            userStack.push(element);
        }

        System.out.println("Элементы в стеке (сверху вниз):");
        while (!userStack.isEmpty()) {
            System.out.println(userStack.pop());
        }

        scanner.close();
    }
}

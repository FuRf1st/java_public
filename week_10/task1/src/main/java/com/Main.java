package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new GenericStack<>();

        System.out.println("Введите количество элементов для добавления в стек:");
        int n = scanner.nextInt();

        System.out.println("Введите " + n + " элементов (целые числа):");
        for (int i = 0; i < n; i++) {
            int element = scanner.nextInt();
            stack.push(element);
        }

        System.out.println("Элементы в стеке (сверху вниз):");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        scanner.close();
    }
}
package com;

import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {
        int maxN = 40; // Максимальный индекс числа Фибоначчи
        System.out.println("Проход проверок...");

        // Сравнение времени
        IntStream.rangeClosed(1, maxN).forEach(n -> {
            long startClassic = System.nanoTime();
            FibonacciClassic.fibonacci(n);
            long timeClassic = System.nanoTime() - startClassic;

            long startMemoized = System.nanoTime();
            FibonacciMemoized.fibonacci(n);
            long timeMemoized = System.nanoTime() - startMemoized;

            System.out.printf("n = %d: Класический = %d ns, Модифицированный = %d ns\n", n, timeClassic, timeMemoized);
        }
        );
    }
}

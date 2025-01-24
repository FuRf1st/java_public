package com;

import java.util.HashMap;

public class FibonacciMemoized {
    private static HashMap<Integer, Long> memo = new HashMap<>();

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        long result = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, result);
        return result;
    }

    public static HashMap<Integer, Long> getMemo() {
        return memo; // Предоставляем доступ для тестов
    }
}

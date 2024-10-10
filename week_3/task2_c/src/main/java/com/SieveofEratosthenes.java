package com;

import java.util.Arrays;

public class SieveofEratosthenes {

    public static boolean[] findPrimes(int n) {
        // Создаём массив для пометки простых чисел
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true); // Сначала все числа простые

        isPrime[0] = false;
        isPrime[1] = false;

        // Цикл расчёта решета Эратосфена
        for (int p = 2; p * p <= n; p++) {
            // Если isPrime[p] не изменилось, то p - простое
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        return isPrime;
    }
}
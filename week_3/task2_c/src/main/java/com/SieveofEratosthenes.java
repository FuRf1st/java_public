package com;

import java.util.Arrays;

public class SieveofEratosthenes {

    public static boolean[] findPrimes(int n) {
        // Создаём массив для пометки простых чисел
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true); // Изначально считаем все числа простыми

        isPrime[0] = false;
        isPrime[1] = false;

        // Основной цикл решета
        for (int p = 2; p * p <= n; p++) {
            // Если isPrime[p] не изменилось, то p - простое
            if (isPrime[p]) {
                // Все кратные p, начиная с p^2, помечаем как составные
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        return isPrime;
    }
}
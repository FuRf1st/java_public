package com;

public class SieveofEratosthenes {
    // Метод для нахождения и вывода простых чисел без использования массивов
    public static void printPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    // Метод для проверки, является ли число простым
    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        // Проверяем делимость числа на все числа от 2 до sqrt(num)
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
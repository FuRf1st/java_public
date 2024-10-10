package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число n для поиска всех простых чисел до n: ");
        int n = scanner.nextInt();

        if (n < 2) {
            System.out.println("Ошибка");
        } 

        else {
            boolean[] primes = SieveofEratosthenes.findPrimes(n);

            System.out.println("Простые числа до " + n + ":");
            for (int i = 2; i <= n; i++) {
                if (primes[i]) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
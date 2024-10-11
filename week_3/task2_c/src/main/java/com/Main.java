package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число n для поиска всех простых чисел до n: ");
        int n = scanner.nextInt();

        if (n < 2) {
            System.out.println("Простых чисел меньше 2 не существует.");
        } else {
            System.out.println("Простые числа до " + n + ":");
            SieveofEratosthenes.printPrimes(n);
        }
    }
}
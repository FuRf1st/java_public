package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод массива чисел
        System.out.println("Введите кол-во эл-ов в массиве:");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        System.out.println("Введите эл-ы массива:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Создаем объект класса MaxFinder
        MaxFinder MaxFinder = new MaxFinder();

        int max = MaxFinder.findMax(numbers);

        int count = MaxFinder.countMax(numbers, max);

        System.out.println("Кол-во чисел, равных максимальному: " + count);
    }
}
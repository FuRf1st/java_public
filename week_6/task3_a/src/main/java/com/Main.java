package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение количества элементов массива
        System.out.println("Введите количество элементов массива:");
        int n = scanner.nextInt();
        Integer[] array = new Integer[n];

        // Чтение элементов массива
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Удаление дубликатов с помощью класса RemoveDuplicates
        Integer[] resultArray = RemoveDuplicates.removeDuplicates(array);

        // Вывод массива без дубликатов
        System.out.println("Массив без дубликатов:");
        for (int num : resultArray) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}

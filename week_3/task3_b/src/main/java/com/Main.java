package com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод данных
        System.out.println("Введите количество элементов массива:");
        int size = scanner.nextInt();

        double[] array = new double[size];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextDouble();
        }

        System.out.println("Исходный массив:");
        for (double num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Сортировка и вывод
        MergeSort.mergeSort(array);

        System.out.println("Отсортированный массив:");
        for (double num : array) {
            System.out.print(num + " ");
        }
    }
}
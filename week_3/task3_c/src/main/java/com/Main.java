package com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите кол-во эл-ов массива:");
        int size = scanner.nextInt();

        double[] array = new double[size];

        System.out.println("Введите эл-ы массива:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextDouble();
        }

        double median = MedianFinder.findMedian(array);

        System.out.println("Медиана: " + median);
    }
}
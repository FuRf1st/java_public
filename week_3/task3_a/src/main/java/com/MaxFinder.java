package com;

public class MaxFinder {
    // Метод для нахождения максимального числа в массиве
    public int findMax(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    // Метод для подсчета количества максимальных чисел
    public int countMax(int[] numbers, int max) {
        int count = 0;
        for (int num : numbers) {
            if (num == max) {
                count++;
            }
        }
        return count;
    }
}
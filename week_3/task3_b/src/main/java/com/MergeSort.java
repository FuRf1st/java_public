package com;

public class MergeSort {

    // Метод сортировки слиянием
    public static void mergeSort(double[] array) {
        if (array.length < 2) {
            return; // Базовый случай: если массив состоит из одного элемента, он уже отсортирован
        }

        // Разделяем массив на две половины
        int mid = array.length / 2;
        double[] left = new double[mid];
        double[] right = new double[array.length - mid];

        // Копируем эл-ты в левую и правую половины
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        // Рекурсивно сортируем каждую половину
        mergeSort(left);
        mergeSort(right);

        // Сливаем отсортированные половины
        merge(array, left, right);
    }

    // Метод для слияния двух отсортированных массивов
    private static void merge(double[] array, double[] left, double[] right) {
        int i = 0, j = 0, k = 0;

        // Пока ни одна из половин не пуста, берем минимальный элемент и добавляем его в результирующий массив
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Копируем оставшиеся элементы из левой половины (если они есть)
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Копируем оставшиеся элементы из правой половины (если они есть)
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}
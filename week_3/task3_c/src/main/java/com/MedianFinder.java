package com;

public class MedianFinder {

    public static void mergeSort(double[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    // Метод для слияния двух отсортированных подмассивов
    private static void merge(double[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        // Сливаем два отсортированных массива обратно в основной массив
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Копируем оставшиеся элементы из leftArray и rightArray
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Метод для нахождения медианы
    public static double findMedian(double[] array) {
        int n = array.length;

        mergeSort(array, 0, n - 1);

        // Если количество элементов нечёт, медиана — центральный элемент
        if (n % 2 != 0) {
            return array[n / 2];
        } else {
            // Если чёт, медиана — это среднее арифметическое двух центральных элементов
            return (array[(n - 1) / 2] + array[n / 2]) / 2.0;
        }
    }
}
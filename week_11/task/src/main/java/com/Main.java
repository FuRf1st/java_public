package com;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Scanner scanner = new Scanner(System.in);

        // Ручной ввод параметров для задачи 1
        System.out.println("Введите начало отрезка a: ");
        double a = scanner.nextDouble();
        System.out.println("Введите конец отрезка b: ");
        double b = scanner.nextDouble();
        System.out.println("Введите количество разбиений n: ");
        int n = scanner.nextInt();

        // Запуск задачи 1: Площадь криволинейной трапеции
        executor.execute(new TrapezoidAreaCalculator(a, b, n));

        // Запуск задачи 2: Энтропия Шеннона
        // Генерация файла с данными, размер которого в 2 раза превышает объем оперативной памяти (32GB в данном примере)
        String filePath = "large_file.bin";
        generateLargeFile(filePath, 32L * 1024 * 1024 * 1024); // 32GB
        executor.execute(new ShannonEntropyCalculator(filePath));

        executor.shutdown();
    }

    private static void generateLargeFile(String filePath, long size) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] buffer = new byte[1024 * 1024]; // 1MB буфер
            long written = 0;

            while (written < size) {
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = (byte) (Math.random() * 256);
                }
                bos.write(buffer);
                written += buffer.length;
            }

            System.out.println("Файл сгенерирован: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
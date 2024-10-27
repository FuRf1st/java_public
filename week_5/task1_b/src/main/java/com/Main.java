package com;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShannonFromFile shannon = new ShannonFromFile();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к текстовому файлу:");
        String filePath = scanner.nextLine();
        scanner.close();

        // Вычисляем и выводим энтропию файла
        try {
            double entropy = shannon.calculateEntropy(filePath);
            System.out.printf("Энтропия по Шеннону для файла '%s': %.4f%n", filePath, entropy);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
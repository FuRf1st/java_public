package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Что ищем: ");
        String searchString = scanner.nextLine();

        System.out.print("Введите кол-во строк для поиска: ");
        int n = Integer.parseInt(scanner.nextLine());

        int totalCount = 0;

        System.out.println("Где ищем:");
        for (int i = 0; i < n; i++) {
            String currentString = scanner.nextLine();
            totalCount += StringEntrances.countOccurrences(currentString, searchString);
        }

        System.out.println("Кол-во вхождений: " + totalCount);
    }
}
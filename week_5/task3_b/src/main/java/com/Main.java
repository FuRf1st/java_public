package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку с показаниями датчиков:");
        String input = scanner.nextLine();

        System.out.println("Выберите поле для сортировки:");
        System.out.println("1 - по id датчика");
        System.out.println("2 - по средней температуре");
        int sortOption = scanner.nextInt();

        OneMoreExtraException processor = new OneMoreExtraException();

        try {
            String[][] results = processor.processOneMoreExtraException(input, sortOption);
            for (String[] result : results) {
                System.out.println(result[0] + " " + result[1]);
            }
        } catch (InvalidSortOptionException | InvalidSensorDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
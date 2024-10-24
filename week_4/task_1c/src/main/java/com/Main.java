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

        DataOfSensors processor = new DataOfSensors();

        String[][] results = processor.processSensorData(input, sortOption);

        for (String[] result : results) {
            System.out.println(result[0] + " " + result[1]);
        }

        scanner.close();
    }
}
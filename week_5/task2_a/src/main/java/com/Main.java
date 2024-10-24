package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TypesCalculator calculator = new TypesCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сообщение:");
        String message = scanner.nextLine();

        System.out.println("Выберите тип данных для преобразования:");
        System.out.println("1. Integer (целое число)");
        System.out.println("2. Double (число с плавающей точкой)");
        System.out.println("3. Boolean (логическое значение)");
        System.out.println("4. String (строка)");
        int choice = scanner.nextInt();
        scanner.close();

        Object result = null;

        switch (choice) {
            case 1:
                result = calculator.toInteger(message);
                break;
            case 2:
                result = calculator.toDouble(message);
                break;
            case 3:
                result = calculator.toBoolean(message);
                break;
            case 4:
                result = calculator.toString(message);
                break;
            default:
                System.out.println("Неверно выбран тип данных.");
                break;
        }

        if (result != null) {
            System.out.println("Результат преобразования: " + result);
        } else {
            System.out.println("Преобразование не удалось.");
        }
    }
}

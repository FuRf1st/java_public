package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Создание объекта Octagon с радиусом r
        Scanner scanner = new Scanner(System.in); // Чтение ввода с клавиатуры с помощью Scanner
        {
            System.out.print("Введите радиус вписанной окружности: ");
            double r = scanner.nextDouble();
            scanner.close();
            
            Octagon octagon = new Octagon(r);

            // Вывод площади и периметра
        System.out.println("Площадь: " + octagon.CalculateArea());
        System.out.println("Периметр: " + octagon.CalculatePerimeter());
        }
    }
}
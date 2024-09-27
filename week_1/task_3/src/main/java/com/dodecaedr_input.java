package com;

import java.util.Scanner;

public class dodecaedr_input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину ребра додекаэдра: ");
        double a = scanner.nextDouble();
        scanner.close();

        dodecaedr_calculator calculator = new dodecaedr_calculator(); // Создаем объект класса для вычислений и передаем длину ребра
        calculator.process(a);
    }
}

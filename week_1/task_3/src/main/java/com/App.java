package com;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); // Чтение ввода с клавиатуры с помощью Scanner
        
        System.out.print("Введите длину ребра додекаэдра: "); // Вводим длину ребра додекаэдра
        double a = scanner.nextDouble();

        scanner.close(); // Закрываем сканер, так как он больше не понадобится

        System.out.printf("Объём додекаэдра: %.3f", ((15 + 7 * Math.sqrt(5)) / 4) * Math.pow(a, 3));  // Выводим значение объёма додекаэдра по формуле
    }
}
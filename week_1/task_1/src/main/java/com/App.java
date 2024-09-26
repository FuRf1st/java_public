package com;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) // Чтение ввода с клавиатуры с помощью Scanner
        {
            System.out.print("Введите ваше имя: "); // Ввод имени
            String username = scanner.nextLine();
            System.out.println("Привет, " + username + "!"); // Вывод "Привет, имя!"
            // Закрываем Scanner
        } // Ввод имени
    }
}
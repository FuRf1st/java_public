package com;

import java.util.Scanner;

public class hello_user {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); // Чтение ввода с клавиатуры с помощью Scanner
        {
            System.out.print("Введите ваше имя: "); // Ввод имени
            String username = scanner.nextLine();
            System.out.println("Привет, " + username + "!"); // Вывод "Привет, имя!"
            // Закрываем Scanner
        }
    }
}
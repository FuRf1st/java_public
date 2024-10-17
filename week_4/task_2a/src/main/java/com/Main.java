package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите адрес электронной почты: ");
        String email = scanner.nextLine();

        // Проверка адреса электронной почты
        if (EmailValidator.isValidEmail(email)) {
            System.out.println("Адрес электронной почты " + email + " является допустимым.");
        }
        
        else {
            System.out.println("Адрес электронной почты " + email + " является недопустимым.");
        }
    }
}

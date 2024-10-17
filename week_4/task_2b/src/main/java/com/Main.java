package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите IPv6-адрес: ");
        String ipv6 = scanner.nextLine();

        // Проверка корректности IPv6-адреса
        if (IPv6Validator.isValidIPv6(ipv6)) {
            System.out.println("IPv6-адрес " + ipv6 + " является допустимым.");
        }
        
        else {
            System.out.println("IPv6-адрес " + ipv6 + " является недопустимым.");
        }
    }
}
package com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку:");
        String input = scanner.nextLine();

        //Регулярное выражение для замены повторений
        String output = input.replaceAll("(.)\\1{2,}", "$1");

        System.out.println("Результат:");
        System.out.println(output);

        scanner.close();
    }
}

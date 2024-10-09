package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите нужный месяц: ");
        int month = scanner.nextInt();

        System.out.print("Введите год: ");
        int year = scanner.nextInt();

        int days = DaysInMonth.getDaysInMonth(month, year);

        System.out.println("В " + month + " месяце " + year + " года " + days + " дней.");
    }
}

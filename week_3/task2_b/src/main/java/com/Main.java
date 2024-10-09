package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число, для которого нужно найти квадратный корень: ");
        double number = scanner.nextDouble();

        double sqrtValue = SquareRoot.findSquareRoot(number);

        System.out.println("Приближённое значение квадратного корня: " + sqrtValue);
    }
}
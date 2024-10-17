package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        double entropy = EntropyCalculator.calculateEntropy(input);
        System.out.printf("Энтропия: %.2f\n", entropy);
    }
}

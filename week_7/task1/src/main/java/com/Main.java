package com;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String input = scanner.nextLine();

        Map.Entry<Character, Long> result = MostFrequentChar.findMostFrequentChar(input);

        System.out.println("Самый часто встречающийся символ: " + result.getKey());
        System.out.println("Количество его повторов: " + result.getValue());
    }
}

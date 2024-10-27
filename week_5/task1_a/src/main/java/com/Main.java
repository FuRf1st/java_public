package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FileReader fileReader = new FileReader();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к текстовому файлу:");
        String filePath = scanner.nextLine();

        fileReader.readFile(filePath);
    }
}
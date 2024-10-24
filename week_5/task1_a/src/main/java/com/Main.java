package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ReaderofFile fileReader = new ReaderofFile();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к текстовому файлу:");
        String filePath = scanner.nextLine();

        fileReader.readFile(filePath);
    }
}
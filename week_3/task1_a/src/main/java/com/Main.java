package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваш возраст: ");
        int age = scanner.nextInt();

        String result = age + " " + AgeDeclension.getCorrectWordForm(age);
        
        System.out.println(result);
    }
}
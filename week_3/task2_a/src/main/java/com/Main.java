package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите высоту пирамиды: ");
        int height = scanner.nextInt();

        System.out.println("Pyramid height: " + height);

        Pyramid.printPyramid(height);
    }
}
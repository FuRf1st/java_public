package com;

public class Pyramid {
    // Метод для построения пирамиды с дырой посередине
    public static void printPyramid(int height) {
        for (int i = 1; i <= height; i++) {

            for (int j = 0; j < height - i; j++) {
                System.out.print(" ");
            }

            // Вывод левой части пирамиды
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }

            // Вывод пробела посередине
            System.out.print(" ");

            // Вывод правой части пирамиды
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }

            System.out.println();
        }
    }
}
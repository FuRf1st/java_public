package com;

public class Main{
    
    public static void main(String[] args) {
        // Примеры классов
        Meet_classes Meet_classes1 = new Meet_classes(); // По умолчанию
        Meet_classes Meet_classes2 = new Meet_classes("Александр", "30.01.2000", "Москва");
        Meet_classes Meet_classes3 = new Meet_classes("Анна", "11.09.2001", "Пенза");

        // Вывод данных класса
        System.out.println("Первая персона:");
        Meet_classes1.displayInfo();

        System.out.println("\nВторая персона:");
        Meet_classes2.displayInfo();

        System.out.println("\nТретья персона:");
        Meet_classes3.displayInfo();
    }
}
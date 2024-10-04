package com;

public class Main{
    
    public static void main(String[] args) {
        // Примеры классов
        Person Person1 = new Person(); // По умолчанию
        Person Person2 = new Person("Александр", "30.01.2000", "Москва");
        Person Person3 = new Person("Анна", "11.09.2001", "Пенза");

        // Вывод данных класса
        System.out.println("Первая персона:");
        Person1.displayInfo();

        System.out.println("\nВторая персона:");
        Person2.displayInfo();

        System.out.println("\nТретья персона:");
        Person3.displayInfo();
    }
}
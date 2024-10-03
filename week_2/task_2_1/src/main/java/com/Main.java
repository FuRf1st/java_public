package com;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        
        // Создание объектов класса Student
        Student student1 = new Student("Роман", LocalDate.of(2005, 12, 18), "23ИС1б", 12345, 4.7);
        Student student2 = new Student("Дмитрий", LocalDate.of(2005, 9, 17), "23ИС1б", 12346, 4.9);
        Student student3 = new Student("Артем", LocalDate.of(2004, 12, 8), "23ИС1б", 12347, 4.2);

        // Мини тестирование
        System.out.println(student1);
        System.out.println("Возраст: " + student1.getAge());
        System.out.println("Хороший студент?: " + student1.isExcellentStudent());

        System.out.println();

        System.out.println(student2);
        System.out.println("Возраст: " + student2.getAge());
        System.out.println("Хороший студент?: " + student2.isExcellentStudent());

        System.out.println();

        System.out.println(student3);
        System.out.println("Возраст: " + student3.getAge());
        System.out.println("Хороший студент?: " + student3.isExcellentStudent());
    }
}
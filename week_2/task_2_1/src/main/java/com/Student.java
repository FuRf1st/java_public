package com;

import java.time.LocalDate;
import java.time.Period;

public class Student {

    private String name;            // Имя студента
    private LocalDate birth_date;    // Дата рождения
    private String group;           // Группа
    private int student_id;          // Код студента
    private double average_score;     // Средний балл

    // Конструктор
    public Student(String name, LocalDate birth_date, String group, int student_id, double average_score) {
        this.name = name;
        this.birth_date = birth_date;
        this.group = group;
        this.student_id = student_id; 
        this.average_score = average_score;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getbirth_date() {
        return birth_date;
    }

    public void setbirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getstudent_id() {
        return student_id; 
    }

    public void setstudent_id(int student_id) {
        this.student_id = student_id; 
    }

    public double getaverage_score() {
        return average_score;
    }

    public void setaverage_score(double average_score) {
        this.average_score = average_score;
    }

    // Получение возраста студента
    public int getAge() {
        return Period.between(birth_date, LocalDate.now()).getYears();  // Возвращает возраст в годах
    }

    // Метод toString для вывода информации о студенте
    @Override
    public String toString() {
        return String.format("Имя: %s, Дата рождения: %s, Группа: %s, ID студента: %d, Средний балл: %.2f",
                name, birth_date, group, student_id, average_score);
    }

    // Проверка того, хорошие ли оценки у студента
    public boolean isExcellentStudent() {
        return average_score >= 4.8;  
    }
}
package com;

public class Author {
    private String name;       // Имя автора
    private int birthYear;     // Год рождения автора

    public Author(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    // Геттер и Сеттер для имени автора
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Геттер и Сеттер для года рождения автора
    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getAuthorInfo() {
        return "Автор: " + name + ", родился в " + birthYear;
    }
}
package com;

public class Octagon {
    // Атрибут innerRadius
    private double innerRadius;

    // Конструктор по умолчанию
    public Octagon() {
        this.innerRadius = 0;
    }

    // Конструктор с параметром
    public Octagon(double innerRadius) {
        this.innerRadius = innerRadius;
    }

    // Метод для установки значения innerRadius
    public void SetinnerRadius(double innerRadius) {
        this.innerRadius = innerRadius;
    }

    // Метод для получения значения innerRadius
    public double GetinnerRadius() {
        return innerRadius;
    }

    // Метод для вычисления площади восьмиугольника
    public double calculateArea() {
        return 8 * (Math.sqrt(2) - 1) * Math.pow(innerRadius, 2);
    }

    // Метод для вычисления периметра восьмиугольника
    public double calculatePerimeter() {
        double sideLength = (innerRadius * 2) / (Math.sqrt(2) + 1);
        return 8 * sideLength;
    }
}
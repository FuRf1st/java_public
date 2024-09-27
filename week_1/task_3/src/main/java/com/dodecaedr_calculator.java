package com;

class dodecaedr_calculator {
    double constant = 15 + 7 * Math.sqrt(5); // Константа для расчета объёма

    private double calculateVolume(double a) { // Приватный метод для вычисления объёма додекаэдра
        return (constant / 4) * Math.pow(a, 3);
    }

    private void printVolume(double volume) { // Приватный метод для вывода объёма
        System.out.printf("Объём додекаэдра: %.3f", volume);  
    }

    public void process(double a) { // Публичный метод для вызова вычисления и вывода
        double volume = calculateVolume(a);
        printVolume(volume);
    }
}
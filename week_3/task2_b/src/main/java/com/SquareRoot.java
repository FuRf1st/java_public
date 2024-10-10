package com;

public class SquareRoot {
    
    public static double findSquareRoot(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Невозможно найти квадратный корень отрицательного числа.");
        }

        if (number == 0) {
            return 0;
        }

        // Начальное приближение (x0)
        double guess = number / 2.0;
        double epsilon = 1e-3;  // Заданная точность
        double difference;

        // Итерации, пока разница между текущим и предыдущим приближением не станет меньше точности
        do {
            double newGuess = (guess + number / guess) / 2.0;
            difference = Math.abs(newGuess - guess);
            guess = newGuess;
        } while (difference > epsilon);

        return guess;
    }
}
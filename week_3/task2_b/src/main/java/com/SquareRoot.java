package com;

public class SquareRoot {
    
    public static double findSquareRoot(double number) {
        // Если число меньше нуля, корень не существует
        if (number < 0) {
            throw new IllegalArgumentException("Невозможно найти квадратный корень отрицательного числа.");
        }

        // Для числа 0 результат сразу 0
        if (number == 0) {
            return 0;
        }

        // Начальное приближение (x0)
        double guess = number / 2.0;
        double epsilon = 1e-3;  // Заданная точность (например, 0.001)
        double difference;

        // Итерации, пока разница между текущим и предыдущим приближением не станет меньше точности
        do {
            double newGuess = (guess + number / guess) / 2.0;
            difference = Math.abs(newGuess - guess);  // Вычисляем разницу
            guess = newGuess;  // Обновляем текущее приближение
        } while (difference > epsilon);  // Продолжаем, пока не достигнем нужной точности

        return guess;  // Возвращаем приближенное значение корня
    }
}
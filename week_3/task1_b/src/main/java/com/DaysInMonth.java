package com;

public class DaysInMonth {
    // Метод для определения количества дней в месяце
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                // Проверяем високосный ли год
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                throw new IllegalArgumentException("Неверный месяц: " + month);
        }
    }

    // Метод для проверки, является ли год високосным
    public static boolean isLeapYear(int year) {
        // Год високосный, если он делится на 4, но не делится на 100,
        // либо если он делится на 400
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
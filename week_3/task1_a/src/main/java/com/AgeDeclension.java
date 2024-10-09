package com;

public class AgeDeclension {
    
    // Метод для определения правильной формы слова "год"
    public static String getCorrectWordForm(int age) {
        int lastDigit = age % 10;
        int lastTwoDigits = age % 100;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 19) {
            return "лет";
        }

        switch (lastDigit) {
            case 1:
                return "год";
            case 2:
            case 3:
            case 4:
                return "года";
            default:
                return "лет";
        }
    }
}

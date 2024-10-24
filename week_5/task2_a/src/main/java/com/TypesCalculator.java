package com;

public class TypesCalculator {

    public Integer toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Невозможно преобразовать в целое число.");
            return null;
        }
    }

    public Double toDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Невозможно преобразовать в число с плавающей точкой.");
            return null;
        }
    }

    public Boolean toBoolean(String input) {
        if (input.equalsIgnoreCase("true")) {
            return true;
        } else if (input.equalsIgnoreCase("false")) {
            return false;
        } else {
            System.out.println("Невозможно преобразовать в логическое значение.");
            return null;
        }
    }

    public String toString(String input) {
        return input;
    }
}

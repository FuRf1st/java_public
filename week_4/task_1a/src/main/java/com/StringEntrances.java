package com;

public class StringEntrances {

    public static int countOccurrences(String str, String searchString) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(searchString, index)) != -1) {
            count++;
            index++; // Увеличиваем индекс на 1, чтобы учитывать перекрывающиеся вхождения
        }

        return count;
    }
}
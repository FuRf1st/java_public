package com;

import java.util.Scanner;

public class DictionaryCheck {
    private Scanner scanner;
    private LatinEnglishDictionary dictionary;

    public DictionaryCheck(Scanner scanner, LatinEnglishDictionary dictionary) {
        this.scanner = scanner;
        this.dictionary = dictionary;
    }

    // Метод для чтения англо-латинских записей и добавления их в словарь
    public void readEntries() {
        System.out.print("Введите число слов и сами слова (построчно): \n");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" - ");
            String englishWord = parts[0];
            String[] latinWords = parts[1].split(", ");
            dictionary.addEntry(englishWord, latinWords);
        }
    }
}
package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создаем экземпляр LatinEnglishDictionary
        LatinEnglishDictionary dictionary = new LatinEnglishDictionary();

        // Создаем экземпляр DictionaryCheck для чтения данных
        DictionaryCheck dictionaryCheck = new DictionaryCheck(scanner, dictionary);

        // Чтение англо-латинских записей и добавление их в словарь
        dictionaryCheck.readEntries();

        // Получаем латинско-английский словарь и выводим его
        Map<String, Set<String>> latinToEnglish = dictionary.getLatinToEnglishDictionary();

        // Вывод количества уникальных латинских слов
        System.out.println(latinToEnglish.size());

        // Вывод латинско-английского словаря в нужном формате
        for (Map.Entry<String, Set<String>> entry : latinToEnglish.entrySet()) {
            String latinWord = entry.getKey();
            List<String> englishTranslations = new ArrayList<>(entry.getValue());
            System.out.println(latinWord + " - " + String.join(", ", englishTranslations));
        }

        scanner.close();
    }
}
package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные в формате: ");
        System.out.println("Количество школьников");
        System.out.println("Количество языков, которые знает каждый школьник, и сами языки");

        List<String> inputData = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            inputData.add(line);
        }

        int studentCount = Integer.parseInt(inputData.get(0).trim());
        LanguageKnowledge languageKnowledge = new LanguageKnowledge();

        int index = 1;

        // Чтение данных для каждого школьника
        for (int i = 0; i < studentCount; i++) {
            int languageCount = Integer.parseInt(inputData.get(index++).trim());
            List<String> currentStudentLanguages = new ArrayList<>();

            for (int j = 0; j < languageCount; j++) {
                String language = inputData.get(index++).trim();
                currentStudentLanguages.add(language);
            }

            languageKnowledge.addStudentLanguages(currentStudentLanguages);
        }

        // Получаем и выводим языки, которые знают все школьники
        List<String> allLanguagesSorted = new ArrayList<>(languageKnowledge.getLanguagesKnownByAll());
        Collections.sort(allLanguagesSorted);
        System.out.println(allLanguagesSorted.size());
        for (String language : allLanguagesSorted) {
            System.out.println(language);
        }

        // Получаем и выводим языки, которые знает хотя бы один школьник
        List<String> anyLanguagesSorted = new ArrayList<>(languageKnowledge.getLanguagesKnownByAny());
        Collections.sort(anyLanguagesSorted);
        System.out.println(anyLanguagesSorted.size());
        for (String language : anyLanguagesSorted) {
            System.out.println(language);
        }

        scanner.close();
    }
}

package com;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class LatinEnglishDictionary {
    private Map<String, Set<String>> latinToEnglish;

    public LatinEnglishDictionary() {
        latinToEnglish = new TreeMap<>();
    }

    // Метод для добавления записей из англо-латинского словаря
    public void addEntry(String englishWord, String[] latinWords) {
        for (String latinWord : latinWords) {
            latinToEnglish.computeIfAbsent(latinWord, k -> new TreeSet<>()).add(englishWord);
        }
    }

    // Метод для получения латинско-английского словаря
    public Map<String, Set<String>> getLatinToEnglishDictionary() {
        return latinToEnglish;
    }
}

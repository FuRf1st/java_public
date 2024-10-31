package com;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static Integer[] removeDuplicates(Integer[] array) {
        // Используем Set для удаления дубликатов
        Set<Integer> uniqueElements = new HashSet<>(Arrays.asList(array));
        return uniqueElements.toArray(new Integer[0]);
    }
}

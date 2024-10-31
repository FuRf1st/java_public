package com;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> perms(List<Integer> numbers) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), numbers);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, List<Integer> numbers) {
        if (tempList.size() == numbers.size()) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < numbers.size(); i++) {
                if (tempList.contains(numbers.get(i))) continue; // пропуск, если элемент уже добавлен
                tempList.add(numbers.get(i));
                backtrack(result, tempList, numbers);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

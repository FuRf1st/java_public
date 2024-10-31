package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите числа через пробел: ");
        String input = scanner.nextLine();
        String[] inputNumbers = input.split(" ");
        
        List<Integer> numbers = new ArrayList<>();
        for (String num : inputNumbers) {
            numbers.add(Integer.parseInt(num));
        }
        
        List<List<Integer>> result = Permutations.perms(numbers);
        System.out.println("Все возможные перестановки: " + result);
    }
}

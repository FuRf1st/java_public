package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите цены акций через запятую (например, 7,1,5,3,6,4): ");
        String input = scanner.nextLine();
        String[] parts = input.split(",");
        
        List<Integer> prices = new ArrayList<>();
        for (String part : parts) {
            prices.add(Integer.parseInt(part.trim()));
        }
        
        int maxProfit = StockProfit.maxProfit(prices);
        System.out.println("Максимальная прибыль: " + maxProfit);
        
        scanner.close();
    }
}

package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SalesReport salesReport = new SalesReport();

        System.out.println("Введите записи о продажах (или пустую строку для завершения):");
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;

            String[] parts = line.split(" ");
            if (parts.length != 3) continue; // Пропускаем некорректные записи
            
            String buyer = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            salesReport.addSale(buyer, product, quantity);
        }
        
        System.out.print(salesReport.getReport());
        
        scanner.close();
    }
}

package com;

import java.util.Map;
import java.util.TreeMap;

public class SalesReport {
    private Map<String, Map<String, Integer>> salesData;

    public SalesReport() {
        salesData = new TreeMap<>();
    }

    public void addSale(String buyer, String product, int quantity) {
        
        salesData.putIfAbsent(buyer, new TreeMap<>());
        Map<String, Integer> products = salesData.get(buyer);

        products.put(product, products.getOrDefault(product, 0) + quantity);
    }

    public String getReport() {
        StringBuilder report = new StringBuilder();
        
        for (String buyer : salesData.keySet()) {
            report.append(buyer).append(":\n");
            Map<String, Integer> products = salesData.get(buyer);
            for (String product : products.keySet()) {
                report.append(product).append(" ").append(products.get(product)).append("\n");
            }
        }
        
        return report.toString();
    }
}

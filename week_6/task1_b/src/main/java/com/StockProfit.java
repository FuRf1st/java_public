package com;

import java.util.List;

public class StockProfit {
    public static int maxProfit(List<Integer> prices) {
        if (prices == null || prices.size() < 2) {
            return 0;
        }
        
        int minPrice = prices.get(0);
        int maxProfit = 0;

        for (int i = 1; i < prices.size(); i++) {
            // Вычисляем текущую потенциальную прибыль
            int potentialProfit = prices.get(i) - minPrice;

            // Обновляем максимальную прибыль, если текущая потенциальная прибыль выше
            maxProfit = Math.max(maxProfit, potentialProfit);

            // Обновляем минимальную цену для покупки
            minPrice = Math.min(minPrice, prices.get(i));
        }

        return maxProfit;
    }
}

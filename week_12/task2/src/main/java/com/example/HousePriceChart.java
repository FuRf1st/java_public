package com.example;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

public class HousePriceChart {

    public static void createHistogram(Map<Integer, Map<String, Integer>> yearlyMaxPrices) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<Integer, Map<String, Integer>> yearEntry : yearlyMaxPrices.entrySet()) {
            Integer year = yearEntry.getKey();
            for (Map.Entry<String, Integer> cityEntry : yearEntry.getValue().entrySet()) {
                String city = cityEntry.getKey();
                Integer price = cityEntry.getValue();

                // Разделяем цену на 1000, чтобы показывать тысячи
                dataset.addValue(price / 1000, city, String.valueOf(year));
            }
        }

        // Создаем гистограмму
        JFreeChart chart = ChartFactory.createBarChart(
                "Наибольшие цены по городам по годам", // заголовок
                "Год", // ось X
                "Цена", // ось Y
                dataset, // данные
                org.jfree.chart.plot.PlotOrientation.VERTICAL, // ориентация
                true, // легенда
                true, // подсказки
                false // URL
        );

        // Получаем график и изменяем ось Y
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        NumberAxis yAxis = new NumberAxis("Цена");

        // Убираем научную нотацию и форматируем числа с разделителями тысяч
        NumberFormat numberFormat = new DecimalFormat("#,###"); // Это форматирует числа с разделителями тысяч
        yAxis.setNumberFormatOverride(numberFormat);

        // Включаем отображение 0 на оси
        yAxis.setAutoRangeIncludesZero(true);

        // Применяем измененную ось Y
        plot.setRangeAxis(yAxis);

        // Отображаем график в окне
        JFrame frame = new JFrame("Гистограмма");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }
}

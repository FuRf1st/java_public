package com;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Map;

public class ChartGenerator {

    public static void showHistogram(Map<Integer, Map<String, Double>> processedData) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<Integer, Map<String, Double>> entry : processedData.entrySet()) {
            int year = entry.getKey();
            for (Map.Entry<String, Double> cityEntry : entry.getValue().entrySet()) {
                String city = cityEntry.getKey();
                Double price = cityEntry.getValue();
                dataset.addValue(price, city, Integer.toString(year));
            }
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Maximum House Prices by City and Year",
                "Year", "Price",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        JFrame frame = new JFrame("House Price Analyzer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}


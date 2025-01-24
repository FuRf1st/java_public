package com;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartExample {
    public static void displayChart(int[] nValues, long[] classicTimes, long[] memoizedTimes) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < nValues.length; i++) {
            dataset.addValue(classicTimes[i], "Classic", String.valueOf(nValues[i]));
            dataset.addValue(memoizedTimes[i], "Memoized", String.valueOf(nValues[i]));
        }

        JFreeChart chart = ChartFactory.createLineChart(
            "Fibonacci Performance",
            "n",
            "Time (ns)",
            dataset
        );

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }
}
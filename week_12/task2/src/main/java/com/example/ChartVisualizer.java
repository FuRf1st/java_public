package com.example;

import java.util.List;
import java.util.Map;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

public class ChartVisualizer {

    public void displayCharts(Map<String, Map<Integer, Double>> cityYearMaxPrice) {
        cityYearMaxPrice.forEach((city, yearPrices) -> {
            CategoryChart chart = new CategoryChartBuilder()
                    .width(800)
                    .height(600)
                    .title("Max House Prices in " + city)
                    .xAxisTitle("Year")
                    .yAxisTitle("Price")
                    .build();

            chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
            chart.getStyler().setAvailableSpaceFill(0.99);

            List<Integer> years = List.copyOf(yearPrices.keySet());
            List<Double> prices = years.stream().map(yearPrices::get).toList();

            chart.addSeries(city, years, prices);

            new SwingWrapper<>(chart).displayChart();
        });
    }
}
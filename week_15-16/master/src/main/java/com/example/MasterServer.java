package com.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JFrame;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MasterServer {
    private static final int PORT = 12345;
    private static Set<ClientHandler> clients = ConcurrentHashMap.newKeySet();
    private static Map<Integer, Map<String, Integer>> aggregatedResults = new HashMap<>();
    private static List<String> linesToDistribute = new ArrayList<>();

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java -jar house-price-server-1.0-SNAPSHOT.jar <path-to-csv-file>");
            return;
        }

        String filePath = args[0];

        try {
            linesToDistribute = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен на порту " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Новое подключение: " + clientSocket);
                ClientHandler clientHandler = new ClientHandler(clientSocket, clients, linesToDistribute);
                clients.add(clientHandler);
                new Thread(clientHandler).start();

                // Если все клиенты подключены, начинаем обработку
                if (clients.size() == 2) { // Предполагаем, что у нас два клиента
                    distributeWork();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void distributeWork() {
        if (linesToDistribute.isEmpty()) {
            System.out.println("No data to distribute.");
            return;
        }

        int chunkSize = linesToDistribute.size() / clients.size();
        int start = 0;

        for (ClientHandler client : clients) {
            int end = Math.min(start + chunkSize, linesToDistribute.size());
            List<String> chunk = linesToDistribute.subList(start, end);
            start = end;
            System.out.println("Sending data to client: " + chunk);
            client.sendData(chunk);
        }
    }

    public static synchronized void aggregateResults(Map<Integer, Map<String, Integer>> results) {
        for (Map.Entry<Integer, Map<String, Integer>> yearEntry : results.entrySet()) {
            Integer year = yearEntry.getKey();
            for (Map.Entry<String, Integer> cityEntry : yearEntry.getValue().entrySet()) {
                String city = cityEntry.getKey();
                Integer price = cityEntry.getValue();
                aggregatedResults.computeIfAbsent(year, k -> new HashMap<>())
                        .merge(city, price, Math::max);
            }
        }
        createHistogram(aggregatedResults);
    }

    private static void createHistogram(Map<Integer, Map<String, Integer>> yearlyMaxPrices) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<Integer, Map<String, Integer>> yearEntry : yearlyMaxPrices.entrySet()) {
            Integer year = yearEntry.getKey();
            for (Map.Entry<String, Integer> cityEntry : yearEntry.getValue().entrySet()) {
                String city = cityEntry.getKey();
                Integer price = cityEntry.getValue();
                dataset.addValue(price / 1000, city, String.valueOf(year));
            }
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Наибольшие цены по городам по годам",
                "Год",
                "Цена",
                dataset,
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        NumberAxis yAxis = new NumberAxis("Цена");
        NumberFormat numberFormat = new DecimalFormat("#,###");
        yAxis.setNumberFormatOverride(numberFormat);
        yAxis.setAutoRangeIncludesZero(true);
        plot.setRangeAxis(yAxis);

        JFrame frame = new JFrame("Гистограмма");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }
}
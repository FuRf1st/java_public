package com.example.master;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Master {
    private static final int PORT = 12345;
    private static final String[] WORKER_IPS = {"localhost"}; // Используем localhost
    private static final String CSV_FILE_PATH = "D:\\pp-2018.csv";

    public static void main(String[] args) {
        List<String[]> data = loadData(CSV_FILE_PATH);
        ExecutorService executor = Executors.newFixedThreadPool(WORKER_IPS.length);

        List<Future<Map<String, Map<Integer, Double>>>> futures = new ArrayList<>();

        for (String ip : WORKER_IPS) {
            futures.add(executor.submit(() -> processData(ip, data)));
        }

        Map<String, Map<Integer, Double>> results = new HashMap<>();

        for (Future<Map<String, Map<Integer, Double>>> future : futures) {
            try {
                Map<String, Map<Integer, Double>> result = future.get();
                results.putAll(result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        plotHistograms(results);
    }

    private static List<String[]> loadData(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private static Map<String, Map<Integer, Double>> processData(String ip, List<String[]> data) {
        Map<String, Map<Integer, Double>> result = new HashMap<>();
        try (Socket socket = new Socket(ip, PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            System.out.println("Master: Sending data to worker at " + ip + ":" + PORT);
            out.writeObject(data);
            out.flush(); // Убедимся, что данные отправлены

            System.out.println("Master: Waiting for result from worker...");
            result = (Map<String, Map<Integer, Double>>) in.readObject();
            System.out.println("Master: Received result from worker: " + result);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void plotHistograms(Map<String, Map<Integer, Double>> results) {
        // Реализуйте построение гистограмм с использованием библиотеки, например JFreeChart
        System.out.println("Master: Plotting histograms with results: " + results);
    }
}
package com.example;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class MasterServer {
    private static final int PORT = 12345;
    private static final int NUM_WORKERS = 4; // Количество воркеров
    private static List<HousePriceRecord> records = new ArrayList<>(); // Здесь будут храниться все записи

    public static void main(String[] args) {
        loadData(); // Загрузка данных из файла (этот метод нужно будет реализовать)

        ExecutorService workerPool = Executors.newFixedThreadPool(NUM_WORKERS);
        Map<Integer, List<HousePriceRecord>> dataChunks = splitData(records, NUM_WORKERS);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен на порту " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Новое подключение: " + clientSocket);

                // Отправка данных воркеру
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

                // Получаем задачи для воркера
                workerPool.submit(new WorkerTask(clientSocket, dataChunks, out, in));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadData() {
        // Реализовать загрузку данных из CSV или другого формата
        // Для примера, добавим фиктивные данные:
        records.add(new HousePriceRecord("London", 2015, 500000));
        records.add(new HousePriceRecord("London", 2016, 510000));
        records.add(new HousePriceRecord("Manchester", 2015, 200000));
        records.add(new HousePriceRecord("Manchester", 2016, 210000));
    }

    private static Map<Integer, List<HousePriceRecord>> splitData(List<HousePriceRecord> data, int numChunks) {
        Map<Integer, List<HousePriceRecord>> chunks = new HashMap<>();
        int chunkSize = data.size() / numChunks;

        for (int i = 0; i < numChunks; i++) {
            int start = i * chunkSize;
            int end = (i + 1) * chunkSize;
            if (i == numChunks - 1) {
                end = data.size(); // Последний кусок
            }
            chunks.put(i, data.subList(start, end));
        }

        return chunks;
    }
}

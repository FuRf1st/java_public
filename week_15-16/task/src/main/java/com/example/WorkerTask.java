package com.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkerTask implements Runnable {
    private Socket clientSocket;
    private Map<Integer, List<HousePriceRecord>> dataChunks;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public WorkerTask(Socket socket, Map<Integer, List<HousePriceRecord>> dataChunks, ObjectOutputStream out, ObjectInputStream in) {
        this.clientSocket = socket;
        this.dataChunks = dataChunks;
        this.out = out;
        this.in = in;
    }

    @Override
    public void run() {
        try {
            // Получаем свой кусок данных
            int workerId = in.readInt();
            List<HousePriceRecord> chunk = dataChunks.get(workerId);

            // Анализируем данные (строим гистограмму цен)
            Map<Integer, Map<String, Double>> histogram = buildHistogram(chunk);

            // Отправляем результаты обратно
            out.writeObject(histogram);
            out.flush();

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<Integer, Map<String, Double>> buildHistogram(List<HousePriceRecord> records) {
        Map<Integer, Map<String, Double>> histogram = new HashMap<>();

        for (HousePriceRecord record : records) {
            histogram
                .computeIfAbsent(record.getYear(), k -> new HashMap<>())
                .put(record.getCity(), record.getPrice());
        }

        return histogram;
    }
}

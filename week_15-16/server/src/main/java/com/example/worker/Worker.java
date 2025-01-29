package com.example.worker;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Worker {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Worker started on port " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Worker: Accepted connection from " + socket.getInetAddress());
                new Thread(() -> handleClient(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

            System.out.println("Worker: Waiting for data from master...");
            List<String[]> data = (List<String[]>) in.readObject();
            System.out.println("Worker: Received data from master: " + data.size() + " rows");

            Map<String, Map<Integer, Double>> result = analyzeData(data);
            System.out.println("Worker: Sending result to master: " + result);
            out.writeObject(result);
            out.flush(); // Убедимся, что данные отправлены

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Map<Integer, Double>> analyzeData(List<String[]> data) {
        Map<String, Map<Integer, Double>> result = new HashMap<>();

        for (String[] row : data) {
            String city = row[2]; // Пример: предположим, что город находится в третьем столбце
            int year = Integer.parseInt(row[1].substring(0, 4)); // Пример: год из даты
            double price = Double.parseDouble(row[3]); // Пример: цена в четвертом столбце

            result.computeIfAbsent(city, k -> new HashMap<>())
                  .merge(year, price, Math::max);
        }

        return result;
    }
}
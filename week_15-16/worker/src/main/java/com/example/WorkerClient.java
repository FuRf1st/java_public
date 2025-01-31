package com.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class WorkerClient {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            StringBuilder dataBuilder = new StringBuilder();
            String fromServer;
            boolean endOfData = false;

            while (!endOfData && (fromServer = in.readLine()) != null) {
                System.out.println("Received data from server: " + fromServer);
                if (fromServer.isEmpty()) {
                    endOfData = true;
                } else {
                    dataBuilder.append(fromServer).append("\n");
                }
            }

            List<String> data = List.of(dataBuilder.toString().split("\n"));
            List<HousePriceRecord> records = HousePriceParser.parseLines(data);
            Map<Integer, Map<String, Integer>> yearlyMaxPrices = HousePriceAnalyzer.getYearlyMaxPrices(records);

            // Отправляем результаты обратно на сервер в JSON формате
            Gson gson = new Gson();
            String resultJson = gson.toJson(yearlyMaxPrices);
            out.println("RESULT" + resultJson);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
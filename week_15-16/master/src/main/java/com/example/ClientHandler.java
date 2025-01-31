package com.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private Set<ClientHandler> clients;
    private PrintWriter out;
    private BufferedReader in;
    private List<String> dataToProcess;

    public ClientHandler(Socket socket, Set<ClientHandler> clients, List<String> dataToProcess) {
        this.clientSocket = socket;
        this.clients = clients;
        this.dataToProcess = dataToProcess;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Отправляем данные клиенту
            sendData(dataToProcess);

            String inputLine;
            StringBuilder resultBuilder = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.startsWith("RESULT")) {
                    // Парсим результаты от клиента в JSON формате
                    Gson gson = new Gson();
                    Map<Integer, Map<String, Integer>> results = gson.fromJson(inputLine.substring(6), new TypeToken<Map<Integer, Map<String, Integer>>>(){}.getType());
                    MasterServer.aggregateResults(results);
                    break; // После получения результата завершаем чтение
                } else {
                    resultBuilder.append(inputLine).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clients.remove(this);
        }
    }

    public void sendData(List<String> data) {
        System.out.println("Sending data to client: " + data);
        out.println(String.join("\n", data));
        out.println(); // Завершающая пустая строка для сигнала окончания данных
    }
}
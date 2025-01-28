package com.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;


public class Client {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            System.out.println("Подключено к серверу.");

            // Отправляем свой ID воркера
            out.writeInt(0);  // ID воркера (это будет передаваться серверу для того, чтобы он знал, какие данные отдать

            // Получаем результаты
            Map<Integer, Map<String, Double>> histogram = (Map<Integer, Map<String, Double>>) in.readObject();
            System.out.println("Получены результаты: " + histogram);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

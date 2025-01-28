package com;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 12345;
    private static Map<String, List<ClientHandler>> chatRooms = new HashMap<>(); // Чат-комнаты и их клиенты

    public static void main(String[] args) {
        System.out.println("Сервер запущен...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Новое соединение: " + socket.getInetAddress());

                // Обрабатываем подключение клиента
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Метод для добавления клиента в чат-комнату
    public static synchronized void joinChatRoom(String roomName, ClientHandler clientHandler) {
        chatRooms.putIfAbsent(roomName, new ArrayList<>());
        chatRooms.get(roomName).add(clientHandler);
    }

    // Метод для отправки сообщения всем клиентам в чат-комнате
    public static synchronized void broadcastMessage(String roomName, String message, ClientHandler sender) {
        List<ClientHandler> clients = chatRooms.get(roomName);
        if (clients != null) {
            for (ClientHandler client : clients) {
                if (client != sender) { // Не отправляем сообщение самому отправителю
                    client.sendMessage(message);
                }
            }
        }
    }
}

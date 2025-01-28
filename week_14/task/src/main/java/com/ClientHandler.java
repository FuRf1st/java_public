package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String chatRoom;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Введите имя чат-комнаты:");
            chatRoom = in.readLine();
            ChatServer.joinChatRoom(chatRoom, this);

            out.println("Вы присоединились к комнате: " + chatRoom);
            broadcast("Пользователь присоединился к комнате.");

            String message;
            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("/exit")) {
                    break;
                }
                broadcast(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            leaveChatRoom();
            closeConnections();
        }
    }

    private void broadcast(String message) {
        ChatServer.broadcastMessage(chatRoom, message, this);
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    private void leaveChatRoom() {
        ChatServer.broadcastMessage(chatRoom, "Пользователь покинул комнату.", this);
    }

    private void closeConnections() {
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

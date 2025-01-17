package ru.otus.chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {
    private int port;
    private List<ClientHandler> clients;
    private AuthenticatedProvider authenticatedProvider;

    public AuthenticatedProvider getAuthenticationProvider() {
        return authenticatedProvider;
    }

    public Server(int port) {
        this.port = port;
        this.clients = new ArrayList<>();
        this.authenticatedProvider = new InMemoryAuthenticationProvider(this);
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту: " + port);
            authenticatedProvider.initialize();
            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(this, socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void subscribe(ClientHandler clientHandler) {
        broadcastMessage("В чат зашел: " + clientHandler.getUsername());
        clients.add(clientHandler);
    }

    public synchronized void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        broadcastMessage("Из чата вышел: " + clientHandler.getUsername());
    }

    public synchronized void broadcastMessage(String message) {
        for (ClientHandler c : clients) {
            c.sendMessage(message);
        }
    }

    public boolean isUsernameBusy(String username) {
        for (ClientHandler c : clients) {
            if (c.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void kickUser(ClientHandler admin, String username) {
        for (ClientHandler c : clients) {
            if (c.getUsername().equals(username)) {
                c.sendMessage("Отключен от чата пользователем " + admin.getUsername());
                admin.sendMessage("Пользователь " + c.getUsername() + " отключен от чата");
                c.disconnect();
                return;
            }
        }
        admin.sendMessage("Пользователь " + username + " не в сети");
    }

    public synchronized void personalMessage(ClientHandler from, String message) {
        String[] words = message.split(" ", 3);
        if (words.length != 3) {
            return;
        }

        String username = words[1];
        message = words[2];

        for (ClientHandler cl : clients) {
            if (cl.getUsername().equals(username)) {
                cl.sendMessage("Личное сообщение от " + from.getUsername() + ": " + message);
                return;
            }
        }
    }
}
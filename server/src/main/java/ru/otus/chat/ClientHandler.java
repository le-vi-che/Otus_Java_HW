package ru.otus.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
//Добавьте пользователям роли: USER, ADMIN
//Для пользователей с ролью ADMIN реализуйте возможность отключения пользователей от чата с помощью команды «/kick username»
public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String username;
    private Role role;

    public String getUsername() {
        return username;
    }

    public void setUser(String username, Role role) {
        this.username = username;
        this.role = role;
    }

    public ClientHandler(Server server, Socket socket) throws IOException {
        this.server = server;
        this.socket = socket;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        new Thread(() -> {
            try {
                System.out.println("Клиент подключился ");
                while (true) {
                    String message = in.readUTF();
                    if (message.equals("/exit")) {
                        sendMessage("/exitok");
                        return;
                    }
                    // /auth login password
                    if (message.startsWith("/auth ")) {
                        String[] elements = message.split(" ");
                        if (elements.length != 3) {
                            sendMessage("Неверный формат команды /auth");
                            continue;
                        }
                        if (server.getAuthenticationProvider()
                                .authenticate(this, elements[1], elements[2])) {
                            break;
                        }
                        continue;
                    }
                    // /reg login password username
                    if (message.startsWith("/reg ")) {
                        String[] elements = message.split(" ");
                        if (elements.length != 4) {
                            sendMessage("Неверный формат команды /reg");
                            continue;
                        }
                        if (server.getAuthenticationProvider()
                                .registration(this, elements[1], elements[2], elements[3])) {
                            break;
                        }
                        continue;
                    }
                    sendMessage("Перед работой с чатом необходимо выполнить аутентификацию "
                + "/auth login password' или регистрацию '/register login password username'");
                }
                System.out.println("Клиент " + username + " успешно прошел аутентификацию");
                //цикл работы
                while (true) {
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.equals("/exit")) {
                            sendMessage("/exitok");
                            break;
                        }
                        if (message.startsWith("/w")) {
                            server.personalMessage(this, message);
                        }

                        if (message.startsWith("/kick")) {
                            if (role != Role.ADMIN) {
                                sendMessage("Нет роли ADMIN");
                                continue;
                            }
                            String[] elements = message.split(" ");
                            server.kickUser(this, elements[1]);
                            continue;
                        }
                        continue;
                    }
                    server.broadcastMessage(username + ": " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }).start();
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        server.unsubscribe(this);
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
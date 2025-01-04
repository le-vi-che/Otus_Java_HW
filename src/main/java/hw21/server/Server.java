package hw21.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                ) {
                    System.out.println("Клиент подключен");
                    out.println("Доступные математические операции: +,-,*,/. Пример ввода -> \"6 + 1\"");

                    String request = in.readLine();
                    String[] parts = request.split(" ");
                    double num1 = Integer.parseInt(parts[0]);
                    String operation = parts[1];
                    double num2 = Integer.parseInt(parts[2]);

                    double result = calculation(num1, num2, operation);
                    out.println("Результат: " + result);

                } catch (IOException e) {
                    System.out.println("Ошибка при обработке клиента: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при запуске сервера: " + e.getMessage());
        }
    }

    private static double calculation(double num1, double num2, String operation) {
        switch (operation) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                if (num1 != 0 || num2 != 0) {
                    return num1 * num2;
                } else {
                    return 0;
                }
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new ArithmeticException("Ошибка: деление на ноль");
                }
            default:
                throw new IllegalArgumentException("Ошибка: неизвестная операция " + operation);
        }
    }
}
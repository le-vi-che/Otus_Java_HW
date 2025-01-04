package hw21.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try (Socket socket = new Socket("localhost", 8080);
                 BufferedReader userIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            ) {
                String operations = userIn.readLine();
                System.out.println(operations);

                System.out.println("Введите данные или 'exit' для выхода: ");
                String userInput = scanner.nextLine();
                out.println(userInput);
                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }

                String result = userIn.readLine();
                System.out.println(result);
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Ошибка при подключении к серверу");
            }
        }
    }
}

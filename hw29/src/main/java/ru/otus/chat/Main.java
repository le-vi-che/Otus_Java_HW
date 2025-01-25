package ru.otus.chat;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.InvalidPathException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Введите имя файла: ");
            String fileName = scanner.nextLine();

            System.out.print("Введите искомую последовательность символов: ");
            String searchString = scanner.nextLine();

            System.out.println("Введенная последовательность встречается " + countSequence(fileName, searchString) + " раз");
        }
    }

    public static int countSequence(String fileName, String searchString) {
        int count = 0;
        if (searchString.trim().isEmpty()) {
            return 0;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int index = 0;
                while ((index = line.indexOf(searchString, index)) != -1) {
                    count++;
                    index += searchString.length(); // Перемещаем индекс вперед
                }
            }
        } catch (IOException | InvalidPathException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
        return count;
    }
}
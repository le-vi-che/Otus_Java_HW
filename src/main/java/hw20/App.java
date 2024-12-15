package hw20;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        File directory = new File("./files");
        File selectedFile = null;
        System.out.println("Директория: " + directory.getAbsolutePath());
        List<File> fileList = getFilesFromDirectory(directory);
        showFiles(fileList);
        while (selectedFile == null) {
            selectedFile = selectFile(fileList);
        }
        showFileContent(selectedFile);
        changeFileContent(selectedFile);
        showFileContent(selectedFile);

    }

    public static List<File> getFilesFromDirectory(File dir) {
        List<File> fileList = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.getName().endsWith(".txt")) {
                fileList.add(file);
            }
        }
        return fileList;
    }

    public static void showFiles(List<File> fileList) {
        System.out.print("Список файлов: ");
        for (File file : fileList) {
            System.out.print(file.getName() + "; ");
        }
        System.out.println();
    }

    public static File selectFile(List<File> fileList) {
        System.out.println("Введите название файла для выбора: ");
        Scanner scanner = new Scanner(System.in);
        String inputName = scanner.next();
        for (File file : fileList) {
            if (file.getName().equals(inputName)) {
                System.out.println("Выбран файл: " + file.getName());
                return file;
            }
        }
        System.out.println("Такого файла не существует!");
        return null;
    }

    public static void showFileContent(File file) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {
            System.out.println("Содержимое файла:");
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeFileContent(File file) {
        System.out.println("Введите текст, для записи в файл:");
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
            Scanner scanner = new Scanner(System.in);
            {
                String customString = scanner.nextLine();
                out.newLine();
                out.write(customString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


package ru.otus.chat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
        private static final Object monitor = new Object();
        private static String currentLetter = "A";

        public static void main(String[] args) {
            ExecutorService executor = Executors.newFixedThreadPool(3);
            executor.execute(() -> {
                printA();
            });
            executor.execute(() -> {
                printB();
            });
            executor.execute(() -> {
                printC();
            });
            executor.shutdown();
        }

        public static void printA(){
            synchronized (monitor) {
                try {
                    for (int i =0; i < 5; i++){
                        while (!currentLetter.equals("A")){
                            monitor.wait();
                        }
                        System.out.print(currentLetter);
                        currentLetter = "B";
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void printB(){
            synchronized (monitor) {
                try {
                    for (int i =0; i < 5; i++){
                        while (!currentLetter.equals("B")){
                            monitor.wait();
                        }
                        System.out.print(currentLetter);
                        currentLetter = "C";
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void printC(){
            synchronized (monitor) {
                try {
                    for (int i =0; i < 5; i++){
                        while (!currentLetter.equals("C")){
                            monitor.wait();
                        }
                        System.out.print(currentLetter);
                        currentLetter = "A";
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}
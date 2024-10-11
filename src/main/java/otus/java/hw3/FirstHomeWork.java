package otus.java.hw3;

import java.util.Scanner;

public class FirstHomeWork {
    public static void main(String[] args) {
        chooseMethod();
    }

    public static void chooseMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от 1 до 5");
        int number = scanner.nextInt();

        if (number == 1) {
            greetings();
        } else if (number == 2) {
            checkSign(18, -9, 14);
        } else if (number == 3) {
            selectColor();
        } else if (number == 4) {
            compareNumbers();
        } else if (number == 5) {
            addOrSubtractAndPrint(12, 2, false);
        }
    }

    public static void greetings() {
        System.out.println("Hello\nWorld\nfrom\nJava");
    }

    public static void checkSign(int a, int b, int c) {
        int result = a + b + c;
        if (result >= 0) {
            System.out.println("Сумма положительная");
        } else if (result < 0) {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor() {
        int data =22;
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data > 10 && data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 22;
        int b = 18;
        if (a >= b) {
            System.out.println(a + ">=" + b);
        } else if (a < b) {
            System.out.println(a + "<" + b);
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            System.out.println(initValue + delta);
        } else {
            System.out.println(initValue - delta);
        }
    }
}

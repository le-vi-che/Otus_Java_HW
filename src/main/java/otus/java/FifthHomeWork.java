package otus.java.hw5;

import java.util.Arrays;

public class FifthHomeWork {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int[] arrTwo = {3, 5, 14, 2, 3, 9, 0, 1, 6};
        int[] arrThree = {3, 1, 13, 0, 11, 15, 6, 3, 9, 4};
        int[] arrFour = {1, 9, 3, 7, 5, 6, 1, 2, 9, 10};

        printString(8, "Java");
        sumElementsOverFive(arrTwo);
        fillArray(arr, 8);
        eachElementPlusNumber(arrThree);
        printBiggerPartArray(arrFour);
    }

    public static void printString(int value, String stringValue) {
        for (int i = 0; i < value; i++) {
            System.out.println(stringValue);
        }
    }

    public static void sumElementsOverFive(int[] arrTwo) {
        int sum = 0;
        for (int i = 0; i < arrTwo.length; i++) {
            if (arrTwo[i] > 5) {
                sum += arrTwo[i];
            }
        }
        System.out.println(sum);

    }

    public static void fillArray(int[] array, int initialValue) {
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }

    }

    public static void eachElementPlusNumber(int[] arrThree) {
        int a = 4;
        for (int i = 0; i < arrThree.length; i++) {
            arrThree[i] = arrThree[i] + a;
        }
        System.out.println(Arrays.toString(arrThree));

    }

    public static void printBiggerPartArray(int[] arrFour) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arrFour.length / 2; i++) {
            sum1 += arrFour[i];
        }

        for (int i = arrFour.length / 2; i < arrFour.length; i++) {
            sum2 += arrFour[i];
        }

        if (sum1 > sum2) {
            System.out.println(sum1);
        } else if (sum1 < sum2) {
            System.out.println(sum2);
        }
    }

}


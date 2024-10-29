package otus.java.lesson7;

public class Lesson7 {
    public static void main(String[] args) {
        int[][] arr = {{3, 7, -6, 0, 1}, {-1, 0, -6, 3, 1}};
        int[][] arrTwo = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        int size = 4;
        sumOfPositiveElements(arr);
        printArray(size);
        zeroDiagonal(arrTwo);
        findMax(arr);
        sumOfSecondRow(arr);
    }

    private static int sumOfPositiveElements(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static void printArray(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void zeroDiagonal(int[][] arrTwo) {
        for (int i = 0; i < arrTwo.length; i++) {
            for (int j = 0; j < arrTwo[i].length; j++) {
                if (i == j) {
                    arrTwo[i][j] = 0;
                }
                System.out.print(arrTwo[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int findMax(int[][] arr) {
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                max = Math.max(max, arr[i][j]);
            }
        }
        System.out.println(max);
        return max;
    }

    public static int sumOfSecondRow(int[][] arr) {
        int sumSecondRow = 0;
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i >= 1)
                    sumSecondRow += arr[1][j];
                else sumSecondRow = -1;
            }
        }
        System.out.println(sumSecondRow);
        return sumSecondRow;
    }
}

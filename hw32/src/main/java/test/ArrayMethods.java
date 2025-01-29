package test;

import java.util.Arrays;

public class ArrayMethods {
    public static void main(String[] args) {
//        int[] array = {2, 1, 2, 2, 3};
//        System.out.println(Arrays.toString(arrayAfterOneOrExcep(array)));
//        System.out.println(checkArrayContainsOnlyOneAndTwo(array));
    }

    public static int[] arrayAfterOneOrExcep(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] == 1) {
                return Arrays.copyOfRange(array, i + 1, array.length);
            }
        }
        throw new RuntimeException("Входной массив не содержит единиц.");
    }

    public static boolean checkArrayContainsOnlyOneAndTwo(int[] array) {
        boolean containOne = false;
        boolean containTwo = false;
        for (int value : array) {
            if (value == 1) {
                containOne = true;
            } else if (value == 2) {
                containTwo = true;
            } else {
                return false;
            }
        }
        return containOne && containTwo;
    }
}

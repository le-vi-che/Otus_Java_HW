package exeptions;

public class App {
    public static void main(String[] args) {
        String[][] arr = {{"13", "6", "4", "0"}, {"6", "44", "3", "0"}, {"9", "1", "5", "12"}, {"18", "0", "0", "13", "6"}};

        try {
            System.out.println("Сумма элементов массива: " + sumStringArray(arr));
        } catch (AppArraySizeExeption | AppArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int sumStringArray(String[][] arr) throws AppArraySizeExeption, AppArrayDataException {
        int result = 0;
        if (arr.length != 4) {
            throw new AppArraySizeExeption("Массив должен быть размером 4x4");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new AppArraySizeExeption("Массив должен быть размером 4x4");
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    result += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(String.format("Не удалось преобразовать элемент массива [%d][%d]", i, j));
                }
            }
        }
        return result;
    }
}
package hw22;

public class App {
    public static void main(String[] args) {
        System.out.println("Запуск однопоточного заполнения массива:");
        long currentTime = System.currentTimeMillis();
        fillArray();
        System.out.println("Время выполнения в одном потоке: " + (System.currentTimeMillis() - currentTime)+ " мс");
        System.out.println("Запуск многопоточного заполнения массива:");
        currentTime = System.currentTimeMillis();
        multiThreadProcess();
        System.out.println("Время выполнения в 4 потоках: " + (System.currentTimeMillis() - currentTime) + " мс");
    }

    public static void fillArray() {
        double[] array = new double[100000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }

    public static void multiThreadProcess() {
        double[] array = new double[100000000];
        try {
            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < array.length / 4; i++) {
                    array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                }
            });
            Thread thread2 = new Thread(() -> {
                for (int i = array.length / 4; i < array.length / 2; i++) {
                    array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                }
            });
            Thread thread3 = new Thread(() -> {
                for (int i = array.length / 2; i < array.length * 3 / 4; i++) {
                    array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                }
            });
            Thread thread4 = new Thread(() -> {
                for (int i = array.length * 3 / 4; i < array.length; i++) {
                    array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                }
            });
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();

            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

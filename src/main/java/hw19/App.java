package hw19;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        PersonDataBase personDataBase = new PersonDataBase();

        Person person1 = new Person("Chika", Position.DIRECTOR);
        Person person2 = new Person("Rika", Position.JANITOR);
        Person person3 = new Person("Chacha", Position.DEVELOPER);
        Person person4 = new Person("Mika", Position.JUNIOR_DEVELOPER);

        personDataBase.add(person1);
        personDataBase.add(person2);
        personDataBase.add(person3);
        personDataBase.add(person4);
        System.out.println(personDataBase);

        System.out.println("-------------------------");
        System.out.println(personDataBase.findById(person1.getId()));
        System.out.println(personDataBase.findById(person2.getId()));
        System.out.println(personDataBase.findById(person3.getId()));
        System.out.println(personDataBase.findById(person4.getId()));

        System.out.println("-------------------------");
        System.out.println(personDataBase.isManager(person1));
        System.out.println(personDataBase.isManager(person2));
        System.out.println(personDataBase.isManager(person3));
        System.out.println(personDataBase.isManager(person4));

        System.out.println("-------------------------");
        System.out.println(personDataBase.isEmployee(person1.getId()));
        System.out.println(personDataBase.isEmployee(person2.getId()));
        System.out.println(personDataBase.isEmployee(person3.getId()));
        System.out.println(personDataBase.isEmployee(person4.getId()));


//        - Написать класс со статическим методом, реализующим сортировку массива
//        - bubbleSort(int array[]) - методом пузырька
//    }

        System.out.println("-------------------------");
        bubbleSort(new int[]{199, 3, -12, 4, 27, 6, 7, 1, -2, 23, 18, 10, 16, 33, 5});
        int[] array = new int[]{199, 3, -12, 4, 27, 6, 7, 1, -2, 23, 18, 10, 16, 33, 5};
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}

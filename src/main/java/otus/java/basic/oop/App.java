package otus.java.basic.oop;

public class App {
    public static void main(String[] args) {
        Cat cat = new Cat("Дези", 18, 2, 0);
        Dog dog = new Dog("Жорик", 27, 4, 2);
        Horse horse = new Horse("Звездочка", 100, 10, 8);

        cat.info();
        cat.swim(0);
        cat.run(14);
        cat.info();

        dog.info();
        dog.run(14);
        dog.swim(20);
        dog.info();

        horse.info();
        horse.run(50);
        horse.swim(20);
        horse.info();
    }
}
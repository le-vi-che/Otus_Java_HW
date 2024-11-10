package otus.java.basic.oop.animals;

public class Cat extends Animal {
    public Cat(String name, int endurance, int speedRun, int speedSwim) {
        super(name, speedRun, speedSwim, endurance);
    }

    @Override
    public int swim(int distance) {
        System.out.println("Все коты не умеют плавать");
        return 0;
    }
}

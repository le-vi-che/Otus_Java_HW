package otus.java.basic.oop.animals;

public class Dog extends Animal {

    public Dog(String name, int endurance, int speedRun, int speedSwim) {
        super(name, speedRun, speedSwim, endurance);
    }

    @Override
    public int swim(int distance) {
         //    Собаки на 1 метр плавания - 2 ед.
        endurance = endurance / (distance * 2);
        if (endurance < 1) {
            System.out.println("Собака " + name + " устала!");
            return -1;
        }
        int time = distance / speedSwim;
        if (endurance > 1) {
            System.out.println("Собака " + name + " проплыла " + distance + " метров со скоростью " + speedRun + " м/с");
        }
        System.out.println("Время плаванья: " + time + " с");

        return time;
    }
}

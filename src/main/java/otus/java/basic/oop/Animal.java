package otus.java.basic.oop;

public abstract class Animal {
    String name;
    int endurance;
    int speedRun;
    int speedSwim;

    public String getName() {
        return name;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getSpeedRun() {
        return speedRun;
    }

    public int getSpeedSwim() {
        return speedSwim;
    }

    public Animal(String name, int speedRun, int speedSwim, int endurance) {
        this.name = name;
        this.speedRun = speedRun;
        this.endurance = endurance;
        this.speedSwim = speedSwim;
    }

    public int run(int distance) {
        endurance = this.endurance / distance;
        if (this.endurance <= 0) {
            System.out.println("Животное " + this.name + " устало!");
            return -1;
        }
        int time = distance / this.speedRun;
        if (this.endurance > 0) {
            System.out.println(this.name + " проплыло " + distance + " метров со скоростью " + this.speedRun + " м/с");
        }
        System.out.println("Время пробежки: " + time + " с");

        return time;
    }

    public abstract int swim(int distance);

    public void info() {
        System.out.println("Кличка: " + this.name + "\n" + "Выносливость: " + this.endurance + "\n" + "Скорость бега: " + this.speedRun + "\n" + "Скорость плаванья " + this.speedSwim);
    }
}

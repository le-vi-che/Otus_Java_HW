package org;

public class Cat {
    private String name;
    private int appetite;
    private boolean isHungry;

    public boolean isHungry() {
        return isHungry;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isHungry = true;

    }

    public void eat(Plate plate) {
        if (isHungry && plate.getFood(appetite)) {
            isHungry = false;
            System.out.println(name + " сыт и есть не хочет");
        } else {
            System.out.println("Кот " + name + " не поел, не хватило еды");
        }
    }

    public void info() {
        System.out.println("Кот " + name + " " + appetite);
    }
}
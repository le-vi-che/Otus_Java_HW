package hw28;

import hw28.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    public Box() {
    }

    public void addFruit(T fruit) {
        this.fruits.add(fruit);
    }

    public double getBoxWeight() {
        double wight = 0.0;
        for (T fruit : fruits) {
            wight += fruit.getWeight();
        }
        return wight;
    }

    public boolean compare(Box<? extends Fruit> otherBox) {
        return Math.abs(this.getBoxWeight() - otherBox.getBoxWeight()) < 0.0001;
    }

    public void pourFromBoxToBox(Box<T> otherBox) {
        otherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "elements=" + fruits +
                '}';
    }
}
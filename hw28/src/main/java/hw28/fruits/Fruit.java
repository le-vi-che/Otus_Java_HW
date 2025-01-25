package hw28.fruits;

public abstract class Fruit {
    protected double weight;

    public Fruit(double wight) {
        this.weight = wight;
    }

    public double getWeight() {
        return this.weight;
    }
}
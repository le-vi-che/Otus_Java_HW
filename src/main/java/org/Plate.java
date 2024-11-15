package org;

public class Plate {
    private final int maxAmountFood;
    private int currentAmountFood;

    public Plate(int maxAmountFood, int currentAmountFood) {
        this.maxAmountFood = maxAmountFood;
        this.currentAmountFood = currentAmountFood;
    }

    public int getMaxAmountFood() {
        return maxAmountFood;
    }

    public int getCurrentAmountFood() {
        return currentAmountFood;
    }

    public void setCurrentAmountFood(int currentAmountFood) {
        this.currentAmountFood = currentAmountFood;
    }

    public void fillPlate() {
        this.currentAmountFood = maxAmountFood;
    }

    public void info() {
        System.out.println("В терелке: " + currentAmountFood + " единиц еды. Максимальное количество единиц еды в тарелке: " + maxAmountFood);
    }

    public boolean getFood(int amountFood) {
        if (amountFood <= 0) {
            System.out.println("Нельзя получить отрицательное количество еды");
            return false;
        }
        if (amountFood > currentAmountFood) {
            System.out.println("В тарелке не хватает " + (amountFood - currentAmountFood) + " ед.еды");
            return false;
        }

        currentAmountFood -= amountFood;
        System.out.println("В тарелке осталось " + currentAmountFood + " ед.еды.");
        return true;
    }

    public void addFoodToPlate(int amountFood) {
        if (amountFood + currentAmountFood > maxAmountFood) {
            System.out.print("Невозможно поместить в тарелку" + amountFood + " ед.еды.");
            return;
        }
        currentAmountFood += amountFood;
    }
}

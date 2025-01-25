package hw28;

import hw28.fruits.Apple;
import hw28.fruits.Fruit;
import hw28.fruits.Orange;

public class MainApp {
    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple(9));
        appleBox.addFruit(new Apple(15));
        System.out.println("Коробка яблок весит: " + appleBox.getBoxWeight());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange(8));
        orangeBox.addFruit(new Orange(16));
        System.out.println("Коробка апельсин весит: " + orangeBox.getBoxWeight());

        System.out.println("Коробки равны по весу? " + appleBox.compare(orangeBox));

        Box<Fruit> fruitBox = new Box<>();
        fruitBox.addFruit(new Orange(12));
        fruitBox.addFruit(new Apple(19));
        System.out.println("Вес коробки фруктов: " + fruitBox.getBoxWeight());

        Box<Apple> anotherAppleBox = new Box<>();
        anotherAppleBox.addFruit(new Apple(11));

        System.out.println("Пересыпаем яблоки из одной коробки в другую.");
        appleBox.pourFromBoxToBox(anotherAppleBox);

        System.out.println("Вес первой коробки с яблоками после пересыпки: " + appleBox.getBoxWeight());
        System.out.println("Вес второй коробки с яблоками: " + anotherAppleBox.getBoxWeight());
    }
}
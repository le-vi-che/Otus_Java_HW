package org.example.ru.otus.lesson10.box;

public class MainAppBox {
    public static void main(String[] args) {
        Box box1 = new Box ("black", "120x20x20");
        Box box2 = new Box ("red", "100x50x20");

        box1.changeColor("yellow");
        box1.info();
        box1.putItem("ball");

    }

}

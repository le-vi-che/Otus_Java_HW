package org.example.ru.otus.lesson10.box;

public class Box {
    private String color;
    private String size;
    private boolean isOpened;
    private String item;

    public Box(String color, String size) {
        this.color = color;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getItem() {
        return item;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void open() {
        if (isOpened) {
            System.out.println("The box is already open");
        } else {
            isOpened = true;
            System.out.println("The box is open");
        }
    }

    public void close() {
        if (!isOpened) {
            System.out.println("The box is already close");
        } else {
            isOpened = false;
            System.out.println("The box is close");
        }
    }

    public void changeColor(String newColor) {
        color = newColor;
        System.out.println("The box changed color on " + color);
    }

    public void info() {
        System.out.println("The " + color + " box has a size: " + size);
    }

    public void putItem(String item) {
        if (this.item != null) {
            System.out.println("There is already an item in the box. Use another box");
        } else if (!this.isOpened) {
            System.out.println("The box is closed. Before you put the item in the box, you need to open it");
        } else {
            this.item = item;
            System.out.println("An item " + item + " is placed in a box ");
        }
    }
}

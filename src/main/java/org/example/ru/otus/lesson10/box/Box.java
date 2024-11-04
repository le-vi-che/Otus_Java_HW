package org.example.ru.otus.lesson10.box;

public class Box {
    private String color;
    private String size;
    private boolean isOpened;
    private boolean isEmpty;

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public boolean isOpened() {
        return isOpened;
    }

    public boolean isEmpty() {
        return isEmpty;
    }


    public Box(String color, String size) {
        this.color = color;
        this.size = size;
    }

    public void open() {
        isOpened = true;
        System.out.println("The box open");

    }

    public void close() {
        isOpened = false;
        System.out.println("The box close");
    }

    public void changeColor(String newColor) {
        color = newColor;
        System.out.println("The box changed color on " + color);
    }

    public void info() {
        System.out.println("The " + color + " box has a size: " + size);
    }

    public void fillingTheBox() {
        System.out.println("Put items in the box");
        if (isOpened == true && isEmpty == true) {
            System.out.println("The box is open and empty, you can place the item in the box");
        }
        if (isOpened == false && isEmpty == true) {
            System.out.println("The box is close and empty");
        }
        if (isOpened == true && isEmpty == false) {
            System.out.println("The box is open and not empty");
        }
        if (isOpened == false && isEmpty == false) {
            System.out.println("The box is close and not empty");
        }
    }

    public void clearingTheBox() {
        System.out.println("Remove items in the box");
        if (isOpened == true && isEmpty == true) {
            System.out.println("The box is open and empty, nothing to delete");
        }
        if (isOpened == false && isEmpty == true) {
            System.out.println("The box is close and empty");
        }
        if (isOpened == true && isEmpty == false) {
            System.out.println("The box is open and not empty, delete the item");
        }
        if (isOpened == false && isEmpty == false) {
            System.out.println("The box is close and not empty");
        }
    }

}

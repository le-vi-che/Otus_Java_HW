package hw19;

public class Person {
    String name;
    Position position;
    Long id;

    public Person(String name, Position position) {
        this.name = name;
        this.position = position;
        this.id = (long) (Math.random() * 1000000);
    }

    public Position getPosition() {
        return position;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{" + name + ", " + position + ", " + id + "}";
    }
}

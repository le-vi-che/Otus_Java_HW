public class Human {
    private String name;
    private Movement currentTransport;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean getOnTransport(Movement transport) {
        if (currentTransport == null) {
            currentTransport = transport;
            System.out.println(name + " сел на транспорт");
            return true;
        }
        System.out.println(name + " уже в транспорте");
        return false;
    }

    public boolean leaveTransport(Movement transport) {
        if (currentTransport == transport) {
            System.out.println(name + " покинул транспорт");
            return true;
        }
        currentTransport = null;
        System.out.println(name + " не в транспортном средстве");
        return false;
    }

    public boolean move(int distance, TypeOfTerrain terrain) {
        if (currentTransport == null) {
            System.out.println(name + " передвигается пешком " + distance + " км");
            return true;
        } else {
            return currentTransport.move(distance, terrain);
        }
    }
}

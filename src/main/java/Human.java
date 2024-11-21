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

    public boolean leaveTransport() {
        if (currentTransport == null) {
            System.out.println(name + " не в транспортном средстве");
            return false;
        }
        System.out.println(name + " покинул транспорт");
        currentTransport = null;
        return true;
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

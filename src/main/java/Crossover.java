public class Crossover implements Movement {
    private int oil;

    public Crossover(int oil) {
        this.oil = oil;
    }

    @Override
    public boolean move(int distance, TypeOfTerrain terrain) {
        if ((oil - (oil / distance) * 10) <= 0) {
            System.out.println("Машина не может пройти дистанцию " + distance + " км. Не хватает бензина");
            return false;
        }
        oil -= (oil / distance) * 10;
        System.out.println("Машина проехала по местности " + terrain + " дистанцию " + distance + " км");
        return true;
    }
}
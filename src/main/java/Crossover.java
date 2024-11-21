public class Crossover implements Movement {
    private int oil;

    public Crossover(int oil) {
        this.oil = oil;
    }

    @Override
    public boolean move(int distance, TypeOfTerrain terrain) {
        int fuelConsumption = distance * 10;
        if (oil / fuelConsumption <= 0){
            System.out.println("Машина не может пройти дистанцию " + distance + " км. Не хватает бензина");
            return false;
        }
        oil -= fuelConsumption;
        System.out.println("Машина проехала по местности " + terrain + " дистанцию " + distance + " км");
        return true;
    }
}
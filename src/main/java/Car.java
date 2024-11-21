public class Car implements Movement {
    private int oil;

    public Car(int oil) {
        this.oil = oil;
    }

    public int getOil() {
        return oil;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    @Override
    public boolean move(int distance, TypeOfTerrain terrain) {
        if (terrain == TypeOfTerrain.FOREST || terrain == TypeOfTerrain.SWAMP) {
            System.out.println("Машина не может проехать по местности " + terrain);
            return false;
        }
        int fuelConsumption = distance * 10;
        if (oil / fuelConsumption <= 0) {
            System.out.println("Машина не может проехать дистанцию " + distance + " км. Не хватает бензина");
            return false;
        }
        oil -= fuelConsumption;
        System.out.println("Машина проехала по местности " + terrain + " дистанцию " + distance + " км");
        return true;
    }
}
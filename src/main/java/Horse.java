public class Horse implements Movement {
    private int power;

    public Horse(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public boolean move(int distance, TypeOfTerrain terrain) {
        if (terrain == TypeOfTerrain.SWAMP) {
            System.out.println("Лошадь не может пройти по местности " + terrain);
            return false;
        }
        if (distance > power) {
            System.out.println("Лошадь не может пройти дистанцию " + distance + " км");
            return false;
        }
        power -= distance;
        System.out.println("Лошадь прошла по местности " + terrain + " дистанцию " + distance + " км");
        return true;
    }
}
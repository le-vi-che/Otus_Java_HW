public class Bicycle implements Movement {


    @Override
    public boolean move(int distance, TypeOfTerrain terrain) {
        if (terrain == TypeOfTerrain.SWAMP) {
            System.out.println("Велосипед не может проехать по местности " + terrain);
            return false;
        }
        System.out.println("Велосипед проехал по местности " + terrain + " дистанцию " + distance + " км");
        return true;
    }
}
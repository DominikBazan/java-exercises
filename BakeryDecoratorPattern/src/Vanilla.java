public class Vanilla extends Cake {

    String cakeName = "Vanilla";

    @Override
    public String getName() {
        return cakeName + " " + super.getName();
    }

    @Override
    public int calculateCost() {
        return 7;
    }
}

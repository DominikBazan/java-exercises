public class Vanilla extends Cake {

    String cakeName = "vanilla";

    @Override
    public String getName() {
        return cakeName + " " + super.getName();
    }

    @Override
    public int calculateCost() {
        return 7;
    }
}

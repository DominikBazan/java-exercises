public class Chocolate extends Cake {

    String cakeName = "Chocolate";

    @Override
    public String getName() {
        return cakeName + " " + super.getName();
    }

    @Override
    public int calculateCost() {
        return 9;
    }
}

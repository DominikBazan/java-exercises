public class Strawberry extends Cake {

    String cakeName = "Strawberry";

    @Override
    public String getName() {
        return cakeName + " " + super.getName();
    }

    @Override
    public int calculateCost() {
        return 14;
    }
}

public class Sprinkles extends  CakeDecorator {

    private Cake cake;

    public Sprinkles(Cake cake) {
        this.cake = cake;
    }

    @Override
    public String getName() {
        return this.cake.getName() + " with sprinkles";
    }

    @Override
    public int calculateCost() {
        return cake.calculateCost() + 2;
    }
}

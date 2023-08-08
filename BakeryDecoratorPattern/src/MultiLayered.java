public class MultiLayered extends  CakeDecorator {

    private Cake cake;

    public MultiLayered(Cake cake) {
        this.cake = cake;
    }

    @Override
    public String getName() {
        return "Multi-layered " + this.cake.getName();
    }

    @Override
    public int calculateCost() {
        return cake.calculateCost() + 5;
    }
}

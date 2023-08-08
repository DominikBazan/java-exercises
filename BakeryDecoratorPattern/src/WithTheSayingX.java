public class WithTheSayingX extends CakeDecorator {

    private Cake cake;
    private String text;

    public WithTheSayingX(Cake cake, String text) {
        this.cake = cake;
        this.text = text;
    }

    @Override
    public String getName() {
        return this.cake.getName() + " with saying '" + this.text + "'";
    }

    @Override
    public int calculateCost() {
        return cake.calculateCost();
    }
}

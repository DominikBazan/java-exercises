public class Main {

    public static void main(String[] args) {
        Cake cake1 = new Chocolate();
        String cake1Name = cake1.getName();

        Cake cake2 = new WithTheSayingX(new Vanilla(), "PLAIN!");
        String cake2Name = cake2.getName();

        Cake cake3 = new WithTheSayingX(new Sprinkles(new Vanilla()), "FANCY");
        String cake3Name = cake3.getName();

        Cake cake4 = new WithTheSayingX(new WithTheSayingX(new Sprinkles(new Sprinkles(new MultiLayered(new Strawberry()))), "One of"), "EVERYTHING");
        String cake4Name = cake4.getName();

        StringBuilder message = new StringBuilder();
        message.append("Welcome customer to the London Royal Bakery!\n");
        message.append("Here is your order:\n");
        message.append(cake1Name).append("\n");
        message.append(cake2Name).append("\n");
        message.append(cake3Name).append("\n");
        message.append(cake4Name).append("\n");

        System.out.println(message);
    }
}
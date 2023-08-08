public class Main {

    public static void main(String[] args) {
        Cake vanillaCake = new Vanilla();
        String productName = vanillaCake.getName();

        StringBuilder message = new StringBuilder();
        message.append("Welcome customer to the London Royal Bakery!\n");
        message.append("Here is your order.\n");
        message.append("Is is called: ");
        message.append(productName);

        System.out.println(message);
    }
}
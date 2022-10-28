import java.math.BigInteger;
import java.util.HashMap;

public class Main {

    private static BigInteger solve(int number) {
        HashMap<Integer, BigInteger> map = new HashMap<>();

        map.put(1, BigInteger.ZERO);
        map.put(2, BigInteger.ONE);

        for (int i = 3; i <= number; i++) {
            map.put(i, BigInteger.TWO.add(map.get(i - 1)).add(map.get(i - 2)));
        }

        return map.get(number);
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        sb.append("Riddle:\n");
        sb.append("A basket labeled 1 is empty.\n" +
                "A basket labeled 2 has one basket labeled 1 inside.\n" +
                "Each basket labeled 3 or higher has two baskets inside,\n" +
                "one of a label being lower by 1 and another one, of a label being lower by 2,\n" +
                "each of them potentially having some more baskets inside, depending on their labels.\n" +
                "How many baskets in total are there in a basket labeled 94?\n\n");
        sb.append("The solution for 94 baskets: ").append(solve(94));

        System.out.println(sb);

        sb = new StringBuilder();
        sb.append("\n\n... but how many baskets in total are there in a basket labeled 300.000?\n\n");
        sb.append("The solution for 300.000 baskets:\n");
        String unreadableSolution = String.valueOf(solve(300000));


        int step = 100;
        int begin = 0;
        int end = step;
        for (int i = 0; i < unreadableSolution.length() / step + 1; i++) {
            sb.append(unreadableSolution, begin, end).append("...\n...");
            begin += step;
            end = Math.min(end + step, unreadableSolution.length());
        }
        sb.replace(sb.length() - 7, sb.length(), "");

        System.out.println(sb);
    }

}
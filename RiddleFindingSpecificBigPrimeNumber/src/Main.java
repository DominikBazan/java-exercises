import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        System.out.print(
                """
               Riddle:
               Fruit: 51680708854858323070
               This fruit collected is not of a prime sort.
               Please, extract a prime one.

               """
        );

        String bigNumberString = "51680708854858323070";
        BigInteger bigNumber = new BigInteger(bigNumberString);
        System.out.println("Big number: " + bigNumberString + "\n");

        for (BigInteger i = BigInteger.ONE; ! i.equals(bigNumber); i = i.add(BigInteger.ONE)) {
            BigInteger[] divideAndRemainder = bigNumber.divideAndRemainder(i);
            if (divideAndRemainder[1].equals(BigInteger.ZERO)) {
                System.out.print("Number " + divideAndRemainder[0] + " is a divider of " + bigNumberString);
                if (checkIfNumberIsPrime(divideAndRemainder[0])) {
                    System.out.print(" and it is a prime number so it is a solution!\n");
                    break;
                } else {
                    System.out.print(" but it isn't a prime number.\n");
                }
            }
        }
    }

    private static boolean checkIfNumberIsPrime(BigInteger bigInteger) {
        BigInteger halfNumber = bigInteger.divide(BigInteger.TWO);
        for (BigInteger dividend = BigInteger.TWO; ! dividend.equals(halfNumber); dividend = dividend.add(BigInteger.ONE)) {
            if (bigInteger.divideAndRemainder(dividend)[1].equals(BigInteger.ZERO)) {
                return false;
            }
        }
        return true;
    }

}
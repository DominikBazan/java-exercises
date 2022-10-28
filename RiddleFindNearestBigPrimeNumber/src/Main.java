import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.print(
                """
                Number: 9242463289
                If we take a number, that is this one, written in reverse order,
                what will be the nearest prime (any direction)?
                
                """
        );

        String bigNumberString = new StringBuilder("9242463289").reverse().toString();
        BigInteger bigNumber = new BigInteger(bigNumberString);
        System.out.println("Big number: " + bigNumberString);

        System.out.println("\nChecking numbers...\n");
        solve(bigNumber);
    }

    private static void solve(BigInteger bigNumber) {
        BigInteger lowerNumber =  new BigInteger(bigNumber.toByteArray());
        BigInteger biggerNumber =  new BigInteger(bigNumber.toByteArray());
        int distance = 0;
        boolean found = false;

        if (isPrime(bigNumber)) {
            printResult(bigNumber, distance);
            found = true;
        }

        while (!found) {
            distance++;
            lowerNumber = lowerNumber.subtract(BigInteger.ONE);
            biggerNumber = biggerNumber.add(BigInteger.ONE);

            if (isPrime(lowerNumber)) {
                printResult(lowerNumber, distance);
                found = true;
            }
            if (isPrime(biggerNumber)) {
                printResult(lowerNumber, distance);
                found = true;
            }
        }
    }

    private static boolean isPrime(BigInteger number) {
        if (!number.isProbablePrime(Integer.MAX_VALUE)) {
            return false;
        } else {
            return checkIfNumberIsPrime(number);
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

    private static void printResult(BigInteger number, int distance) {
        System.out.println("Nearest prime (any direction): " + number + " (distance: " + distance + " numbers).");
    }

}

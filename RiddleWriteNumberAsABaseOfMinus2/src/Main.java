import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

    static String bigNumberString = "9823642429";
    static int lengthOfTheListOfValuesForIndexes = 35;

    static ArrayList<BigInteger> valesForIndexes;
    static int maxIndex;

    public static void main(String[] args) throws Exception {
        System.out.print(
                """
                Riddle:
                Number: 9823642429
                Write the number as a base "-2" number ;)
                
                """
        );

        // 1. Create a list of successive powers of -2
        valesForIndexes = new ArrayList<>();
        for (int i = 0; i < lengthOfTheListOfValuesForIndexes; i++) {
            valesForIndexes.add(BigInteger.valueOf((long) Math.pow(-2, i)));
        }

        // 2. Find the number of digits in the number you are looking for
        BigInteger bigNumber = new BigInteger(bigNumberString);
        BigInteger valueRepresentedByMaxIndex = BigInteger.valueOf(0);
        for (maxIndex = 0; maxIndex < valesForIndexes.size() + 2; maxIndex += 2) {
            if (maxIndex > (valesForIndexes.size() - 1)) {
                throw new Exception("Value of \"lengthOfThrListOfValuesOfIndexes\" is to low!");
            }
            valueRepresentedByMaxIndex = valueRepresentedByMaxIndex.add(valesForIndexes.get(maxIndex));
            if (bigNumber.compareTo(valueRepresentedByMaxIndex) < 0) {
                break;
            }
        }
        // The number of digits in the number you are looking for is : maxIndex + 1

        // 3. Manual looking for the number close to the number you are looking for
        printSingleConversion("10000000000000000000000000000000001");
        printSingleConversion("11000000000000000000000000000000001");
        printSingleConversion("11001000000000000000000000000000001");
        printSingleConversion("11001010000000000000000000000000001");
        printSingleConversion("11001011000000000000000000000000001");
        printSingleConversion("11001011100000000000000000000000001");
        printSingleConversion("11001011110000000000000000000000001");

        System.out.println("\nCalculating...\n");

        // 4. Automatic looking for the number the final number you are looking for
        System.out.println("The number you are looking for: " + findTheNumber("1100101111"));
    }

    private static void printSingleConversion(String num) {
        System.out.println("-2: " + num + " -> 10: " + minus2To10(num));
    }

    // A method that converts a minus binary number to a decimal number
    static String minus2To10(String minus2NumberString) {
        BigInteger result = new BigInteger("0");
        int valueIndex = 0;
        for (int i = minus2NumberString.length() - 1; i >= 0; i--) {
            if (minus2NumberString.charAt(i) == '1') {
                result = result.add(valesForIndexes.get(valueIndex));
            }
            valueIndex++;
        }
        return result.toString();
    }

    // Recursive method to find the number you are looking for based on first digits of it
    private static String findTheNumber(String prefix) {
        if (prefix.length() == maxIndex) {
            // the last digit will always be '1' because the number you are looking for is odd
            if (bigNumberString.equals(minus2To10(prefix + "1"))) {
                return prefix + "1";
            } else {
                return null;
            }
        } else {
            String result = findTheNumber(prefix + "1");
            if (result != null) {
                return result;
            }
            return findTheNumber(prefix + "0");
        }
    }

}

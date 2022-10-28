import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        long longFirst = 2_147_480_000L;
        long longLast = 2_147_483_648L;

        StringBuilder sb = new StringBuilder();
        sb.append("Prime numbers found in range: <first, last> where first = ").append(longFirst)
                .append(" and last = ").append(longLast).append(" using long datatype: ...");

        System.out.println(sb);

        System.out.println(sieveOfEratosthenesForRangeUsingLongDatatype(longFirst, longLast));

        BigInteger bigFirst = new BigInteger("2147484000");
        BigInteger bigLast = new BigInteger("2147485000");

        sb = new StringBuilder();
        sb.append("\nPrime numbers found in range: <first, last> where first = ").append(bigFirst)
                .append(" and last = ").append(bigLast).append(" using BigInteger datatype: ...");

        System.out.println(sb);

        System.out.println(sieveOfEratosthenesForRangeUsingBigIntegerDatatype(bigFirst, bigLast));
    }

    public static List<Long> sieveOfEratosthenesForRangeUsingLongDatatype(long first, long last) {
        boolean[] prime = new boolean[(int) (last - first + 1)];
        Arrays.fill(prime, true);
        for (long n = 2; n <= (last / 2); n++) {
            if (n < first || prime[(int) (n - first)]) {
                for (long nn = n + n; nn <= last; nn += n) {
                    if (nn >= first) {
                        prime[(int) (nn - first)] = false;
                    }
                }
            }
        }
        List<Long> primeNumbers = new ArrayList<>(Collections.emptyList());
        for (int ix = 0; ix < prime.length; ix++) {
            if (prime[ix]) {
                primeNumbers.add(ix + first);
            }
        }
        return primeNumbers;
    }

    public static List<BigInteger> sieveOfEratosthenesForRangeUsingBigIntegerDatatype(BigInteger first, BigInteger last) throws Exception {
        BigInteger arrayLength = last.subtract(first).add(BigInteger.ONE);
        if (arrayLength.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new Exception("Too large range. Maximum is " + Integer.MAX_VALUE + " numbers.");
        }
        boolean[] prime = new boolean[arrayLength.intValue()];
        Arrays.fill(prime, true);
        for (BigInteger n = BigInteger.TWO; !(n.compareTo(last.divide(BigInteger.TWO)) > 0); n = n.add(BigInteger.ONE)) {
            if (n.compareTo(first) < 0 || prime[n.subtract(first).intValue()]) {
                for (BigInteger nn = n.multiply(BigInteger.TWO); !(nn.compareTo(last) > 0); nn = nn.add(n)) {
                    if (!(nn.compareTo(first) < 0)) {
                        prime[nn.subtract(first).intValue()] = false;
                    }
                }
            }
        }
        List<BigInteger> primeNumbers = new ArrayList<>(Collections.emptyList());
        for (BigInteger ix = BigInteger.ZERO; ix.compareTo(BigInteger.valueOf(prime.length)) < 0; ix = ix.add(BigInteger.ONE)) {
            if (prime[ix.intValue()]) {
                primeNumbers.add(new BigInteger(String.valueOf(ix.add(first))));
            }
        }
        return primeNumbers;
    }

}
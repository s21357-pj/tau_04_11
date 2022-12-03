package pjatk.tau;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BigArmstrongNumber {
    private static int getNumOfDigits(BigInteger number) {
        return String.valueOf(number).length();
    }

    public static boolean isArmstrong(BigInteger number) {
        BigInteger orgNumber = new BigInteger(number.toString());
        BigInteger sum = BigInteger.ZERO;
        int digit = 0;
        BigInteger digitPow = BigInteger.ZERO;
        int numOfDigits = getNumOfDigits(number);
        List<Integer> digits = new ArrayList<Integer>();
        List<BigInteger> digitPows = new ArrayList<BigInteger>();

        while (number.compareTo(BigInteger.ZERO) > 0) {
            digit = number.mod(new BigInteger("10")).intValue();
            digitPow = new BigInteger(String.valueOf(digit)).pow(numOfDigits);
            sum = sum.add(new BigInteger(String.valueOf(digitPow)));
            number = number.divide(new BigInteger("10"));

            digits.add(digit);
            digitPows.add(digitPow);
        }

        boolean armstrong = sum.equals(orgNumber);;
        return armstrong;
    }

}
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        String number1 = "123";
        String number2 = "456";

        String sum = addStrings(number1, number2);

        System.out.println("Сумма: " + sum);
    }

    private static String addStrings(String num1, String num2) {
        BigInteger bigNum1 = new BigInteger(num1);
        BigInteger bigNum2 = new BigInteger(num2);
        BigInteger result = bigNum1.add(bigNum2);

        return result.toString();
    }
}

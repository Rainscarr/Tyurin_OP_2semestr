import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        int nextPermutation = getNextPermutation(number);

        if (nextPermutation == -1) {
            System.out.println("-1");
        } else {
            System.out.println("Следующая перестановка: " + nextPermutation);
        }
    }

    private static int getNextPermutation(int number) {
        char[] digits = String.valueOf(number).toCharArray();

        int i;
        for (i = digits.length - 2; i >= 0; i--) {
            if (digits[i] < digits[i + 1]) {
                break;
            }
        }

        if (i < 0) {
            return -1;
        }

        int j;
        for (j = digits.length - 1; j > i; j--) {
            if (digits[j] > digits[i]) {
                break;
            }
        }

        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        Arrays.sort(digits, i + 1, digits.length);

        int nextPermutation;
        try {
            nextPermutation = Integer.parseInt(String.valueOf(digits));
        } catch (NumberFormatException e) {
            return -1;
        }

        return nextPermutation;
    }
}

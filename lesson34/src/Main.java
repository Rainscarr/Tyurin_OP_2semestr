import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] weights = input.split(" ");

        Arrays.sort(weights, new Comparator<String>() {
            public int compare(String s1, String s2) {
                int sum1 = calculateDigitSum(s1);
                int sum2 = calculateDigitSum(s2);
                if (sum1 != sum2) {
                    return Integer.compare(sum2, sum1);
                } else {
                    return s1.compareTo(s2);
                }
            }
        });

        for (String weight : weights) {
            System.out.print(weight + " ");
        }
    }

    public static int calculateDigitSum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }
        return sum;
    }
}

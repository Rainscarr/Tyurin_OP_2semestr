import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        scanner.close();
        int longestPalindromeLength = findLongestPalindrome(input);
        System.out.println("Длинейший палиндром в строке: " + longestPalindromeLength);
    }

    public static int findLongestPalindrome(String input) {
        int n = input.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int longestPalindromeLength = 1;

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;


                if (input.charAt(i) == input.charAt(j) && (len == 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    longestPalindromeLength = len;
                }
            }
        }

        return longestPalindromeLength;
    }
}

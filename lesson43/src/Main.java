public class Main {
    public static void main(String[] args) {
        int[][] pyramid = {
                {3},
                {7, 4},
                {2, 4, 6},
                {8, 5, 9, 3}
        };

        int maxSum = calculateMaxSlidingSum(pyramid);

        System.out.println("Максимальная сумма скольжения: " + maxSum);
    }

    private static int calculateMaxSlidingSum(int[][] pyramid) {
        int height = pyramid.length;

        int[][] dp = new int[height][height];

        for (int i = height - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (i == height - 1) {
                    dp[i][j] = pyramid[i][j];
                } else {
                    dp[i][j] = pyramid[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
                }
            }
        }

        return dp[0][0];
    }
}

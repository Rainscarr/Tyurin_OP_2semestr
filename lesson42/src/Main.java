import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {6, 10}, {11, 15}};

        int count = countNumbers(intervals);

        System.out.println("Количество чисел: " + count);
    }

    private static int countNumbers(int[][] intervals) {
        int count = 0;

        for (int[] interval : intervals) {
            count += interval[1] - interval[0] - 1;
        }

        return count + intervals.length;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20};

        String ranges = getNumberRanges(numbers);

        System.out.println("Диапазоны: " + ranges);
    }

    private static String getNumberRanges(int[] numbers) {
        List<String> ranges = new ArrayList<>();

        int start = numbers[0];
        int prev = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] - prev != 1) {
                ranges.add(getRangeString(start, prev));
                start = numbers[i];
            }
            prev = numbers[i];
        }

        ranges.add(getRangeString(start, prev));

        return String.join(",", ranges);
    }

    private static String getRangeString(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        } else {
            return start + "-" + end;
        }
    }
}

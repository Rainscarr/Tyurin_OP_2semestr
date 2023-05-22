import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String romanYear = "MXXIII";

        int arabicYear = convertToArabic(romanYear);

        System.out.println("Арабское представление: " + arabicYear);
    }

    private static int convertToArabic(String romanYear) {
        Map<Character, Integer> romanMap = createRomanMap();

        int arabicYear = 0;
        int prevValue = 0;

        for (int i = romanYear.length() - 1; i >= 0; i--) {
            char currentSymbol = romanYear.charAt(i);
            int currentValue = romanMap.get(currentSymbol);

            if (currentValue < prevValue) {
                arabicYear -= currentValue;
            } else {
                arabicYear += currentValue;
                prevValue = currentValue;
            }
        }

        return arabicYear;
    }

    private static Map<Character, Integer> createRomanMap() {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        return romanMap;
    }
}

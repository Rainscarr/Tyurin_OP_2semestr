import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String cipheredText = "шифр, который нужно расшифровать";

        Map<Character, Integer> frequencies = getFrequencies(cipheredText);

        frequencies.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }


    public static Map<Character, Integer> getFrequencies(String text) {
        Map<Character, Integer> frequencies = new HashMap<>();

        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
            }
        }

        return frequencies;
    }
}
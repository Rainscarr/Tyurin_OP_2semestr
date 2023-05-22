import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите исходный текст: ");
        String inputText = scanner.nextLine();

        String transformedText = transformText(inputText);

        System.out.println("Исходный текст: ");
        System.out.println(inputText);
        System.out.println("Измененный текст: ");
        System.out.println(transformedText);
    }

    private static String transformText(String inputText) {
        StringBuilder transformedText = new StringBuilder();
        String[] words = inputText.split("(?<=\\b|[^\\p{L}])");

        for (String word : words) {
            if (!word.isEmpty()) {
                if (Character.isLetter(word.charAt(0))) {
                    String modifiedWord = word.substring(1) + word.charAt(0) + "ауч";
                    transformedText.append(modifiedWord);
                } else {
                    transformedText.append(word);
                }
            }
        }

        return transformedText.toString();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        System.out.print("Введите число сдвига: ");
        int shift = scanner.nextInt();
        System.out.print("Введите направление (1 - шифрование, -1 - дешифрование): ");
        int direction = scanner.nextInt();
        scanner.close();

        String result = caesarCipher(input, shift, direction);
        System.out.println("Результат: " + result);
    }

    public static String caesarCipher(String input, int shift, int direction) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                int offset = direction * shift;

                char shiftedChar = (char) (c + offset);

                if ((Character.isLowerCase(c) && (shiftedChar > 'z' || shiftedChar < 'a'))
                        || (Character.isUpperCase(c) && (shiftedChar > 'Z' || shiftedChar < 'A'))) {
                    shiftedChar = (char) (c + (offset - 26 * direction));
                }

                result.append(shiftedChar);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}

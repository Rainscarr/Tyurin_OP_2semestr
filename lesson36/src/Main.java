import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] secretCode = generateSecretCode();
        int maxAttempts = 20;
        int attemptCount = 0;

        System.out.println("Добро пожаловать в игру!");
        System.out.println("Код состоит из 4-х чисел. Введите вашу попытку:");

        while (attemptCount < maxAttempts) {
            int[] guess = getGuessFromUser();
            attemptCount++;

            int[] guessResult = checkGuess(secretCode, guess);

            System.out.println("Попытка #" + attemptCount + ":");
            System.out.println("Совпадение: " + guessResult[0]);
            System.out.println("Правильное место: " + guessResult[1]);

            if (guessResult[1] == 4) {
                System.out.println("Поздравляем! Вы разгадали код!");
                return;
            }
        }

        System.out.println("Вы исчерпали все попытки. Код не разгадан.");
        System.out.println("Правильный код: " + Arrays.toString(secretCode));
    }

    private static int[] generateSecretCode() {
        int[] code = new int[4];
        Random random = new Random();

        for (int i = 0; i < code.length; i++) {
            code[i] = random.nextInt(10);
        }

        return code;
    }

    private static int[] getGuessFromUser() {
        int[] guess = new int[4];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < guess.length; i++) {
            guess[i] = scanner.nextInt();
        }

        return guess;
    }

    private static int[] checkGuess(int[] secretCode, int[] guess) {
        int[] result = new int[2];
        boolean[] matched = new boolean[4];

        for (int i = 0; i < secretCode.length; i++) {
            if (secretCode[i] == guess[i]) {
                result[1]++;
                matched[i] = true;
            }
        }

        for (int i = 0; i < secretCode.length; i++) {
            for (int j = 0; j < guess.length; j++) {
                if (!matched[i] && secretCode[i] == guess[j]) {
                    result[0]++;
                    matched[i] = true;
                    break;
                }
            }
        }

        return result;
    }
}

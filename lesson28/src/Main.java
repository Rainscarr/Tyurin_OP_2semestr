import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int n = scanner.nextInt();
        scanner.close();

        int[] result = Squares(n);
        if (result != null) {
            System.out.println("Два последовательных квадрата чисел, разница между которыми равна " + n + ":");
            System.out.println((result[1] * result[1]) + " - " + (result[0] * result[0]));
        } else {
            System.out.println("Для числа " + n + " не существует двух последовательных квадратов чисел с такой разницей.");
        }
    }

    public static int[] Squares(int n) {
        int[] result = new int[2];
        int sqrt1 = (int) Math.sqrt(n + 1);
        int sqrt2 = (int) Math.sqrt(n + 1 + n);
        for (int i = sqrt1; i <= sqrt2; i++) {
            int square1 = i * i;
            int square2 = (i + 1) * (i + 1);
            if (square2 - square1 == n) {
                result[0] = i;
                result[1] = i + 1;
                return result;
            }
        }
        return null;
    }
}

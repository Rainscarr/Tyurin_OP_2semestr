import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите N: ");
        int N = scanner.nextInt();

        System.out.print("Введите первый делитель: ");
        int divisor1 = scanner.nextInt();

        System.out.print("Введите второй делитель: ");
        int divisor2 = scanner.nextInt();

        int sum = calculateSeriesSum(N, divisor1, divisor2);

        System.out.println("Сумма чисел в ряде, делящихся на " + divisor1 + " или " + divisor2 + ": " + sum);
    }

    public static int calculateSeriesSum(int N, int divisor1, int divisor2) {
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            if (i % divisor1 == 0 || i % divisor2 == 0) {
                sum += i;
            }
        }

        return sum;
    }
}

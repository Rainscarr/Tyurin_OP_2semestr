import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите начало ряда M: ");
        int m = scanner.nextInt();
        System.out.print("Введите конец ряда N: ");
        int n = scanner.nextInt();
        System.out.print("Введите количество делителей: ");
        int numDivisors = scanner.nextInt();

        int[] divisors = new int[numDivisors];
        System.out.println("Введите делители через пробел: ");
        for (int i = 0; i < numDivisors; i++) {
            divisors[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int i = m; i <= n; i++) {
            boolean isDivisible = false;
            for (int divisor : divisors) {
                if (i % divisor == 0) {
                    isDivisible = true;
                    break;
                }
            }
            if (isDivisible) {
                sum += i;
            }
        }

        System.out.println("Сумма чисел, делящихся на один из делителей: " + sum);
    }
}
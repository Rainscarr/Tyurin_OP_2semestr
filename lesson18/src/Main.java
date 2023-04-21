import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод размера массива
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        // Ввод элементов массива
        int[] arr = new int[size];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Нахождение максимального значения
        int max = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Формирование массивов слева и справа от максимального значения
        int[] leftArray = new int[size];
        int[] rightArray = new int[size];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] < max) {
                leftArray[leftIndex++] = arr[i];
            } else if (arr[i] > max) {
                rightArray[rightIndex++] = arr[i];
            }
        }

        // Удаление лишних элементов из массивов слева и справа
        leftArray = Arrays.copyOf(leftArray, leftIndex);
        rightArray = Arrays.copyOf(rightArray, rightIndex);

        // Вывод результатов
        System.out.println("Максимальное значение: " + max);
        System.out.println("Массив слева от максимального значения: " + Arrays.toString(leftArray));
        System.out.println("Массив справа от максимального значения: " + Arrays.toString(rightArray));
    }
}

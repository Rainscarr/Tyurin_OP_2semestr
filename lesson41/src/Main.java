import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество секунд: ");
        int seconds = scanner.nextInt();

        String time = calculateTime(seconds);

        System.out.println(time);
    }

    private static String calculateTime(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int remainingSeconds = seconds % 60;

        StringBuilder sb = new StringBuilder();

        if (hours > 0) {
            sb.append(hours).append(hours == 1 ? " час" : " часа").append(", ");
        }

        if (minutes > 0) {
            sb.append(minutes).append(minutes == 1 ? " минуту" : " минуты").append(" и ");
        }

        sb.append(remainingSeconds).append(remainingSeconds == 1 ? " секунду" : " секунды");

        return sb.toString();
    }
}

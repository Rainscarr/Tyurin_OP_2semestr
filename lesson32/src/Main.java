public class Main {
    public static String getWinner(long n) {
        // Если количество палочек четное, то побеждает второй игрок (Таня)
        // Если количество палочек нечетное, то побеждает первый игрок (Саша)
        return n % 2 == 0 ? "Таня" : "Саша";
    }

    public static void main(String[] args) {
        long n = 18; // Количество палочек в начале игры
        String winner = getWinner(n);
        System.out.println("Победитель: " + winner);
    }
}

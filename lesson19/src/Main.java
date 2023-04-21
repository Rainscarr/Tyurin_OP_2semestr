public class Main {
    public static int func(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n % 2 == 0) {
            return func(n / 2);
        } else {
            return func(n / 2) + func(n / 2 + 1);
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int result = func(n);
        System.out.println("func(" + n + ") = " + result);
    }
}

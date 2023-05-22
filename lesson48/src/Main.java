import java.util.HashSet;
import java.util.Set;

public class Main {
    public static Set<Integer> generateU(int n) {
        Set<Integer> uSet = new HashSet<>();
        uSet.add(1);

        for (int x = 1; x <= n; x++) {
            int y = 2 * x + 1;
            int z = 3 * x + 1;

            uSet.add(y);
            uSet.add(z);
        }

        return uSet;
    }

    public static void main(String[] args) {
        int n = 10;
        Set<Integer> uSet = generateU(n);
        System.out.println(uSet);
    }
}
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numberOfPlayers = 7;
        int startingPlayer = 1;

        List<Integer> players = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(i);
        }

        List<Integer> eliminatedPlayers = playEveryThirdGame(players, startingPlayer);

        System.out.println("Eliminated Players: " + eliminatedPlayers);
        System.out.println("Winner: " + players.get(0));
    }

    private static List<Integer> playEveryThirdGame(List<Integer> players, int startingPlayer) {
        List<Integer> eliminatedPlayers = new ArrayList<>();
        int currentIndex = startingPlayer - 1;

        while (players.size() > 1) {
            currentIndex = (currentIndex + 2) % players.size();
            eliminatedPlayers.add(players.remove(currentIndex));
        }

        return eliminatedPlayers;
    }
}

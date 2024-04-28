package huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();  // m is read but not used directly in further processing
        scanner.nextLine(); // Consume the rest of the line after reading n and m

        Player[] players = new Player[n];
        String[] shotsData = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            players[i] = new Player(i + 1, shotsData[i]);
        }

        Arrays.sort(players);
        for (int i = 0; i < players.length; i++) {
            System.out.print(players[i].id);
            if (i < players.length - 1) {
                System.out.print(" ");
            }
        }
    }
}

class Player implements Comparable<Player> {
    int id;
    int totalGoals = 0;
    int maxConsecutiveGoals = 0;
    List<Integer> missIndexes = new ArrayList<>();

    public Player(int id, String shots) {
        this.id = id;
        calculateStats(shots);
    }

    private void calculateStats(String shots) {
        int currentStreak = 0;

        for (int i = 0; i < shots.length(); i++) {
            if (shots.charAt(i) == '1') {
                currentStreak++;
                totalGoals++;
            } else {
                if (currentStreak > maxConsecutiveGoals) {
                    maxConsecutiveGoals = currentStreak;
                }
                currentStreak = 0;
                missIndexes.add(i + 1);
            }
        }

        if (currentStreak > maxConsecutiveGoals) {
            maxConsecutiveGoals = currentStreak;
        }
    }

    @Override
    public int compareTo(Player other) {
        if (this.totalGoals != other.totalGoals) {
            return Integer.compare(other.totalGoals, this.totalGoals);
        }
        if (this.maxConsecutiveGoals != other.maxConsecutiveGoals) {
            return Integer.compare(other.maxConsecutiveGoals, this.maxConsecutiveGoals);
        }
        for (int i = 0; i < Math.min(this.missIndexes.size(), other.missIndexes.size()); i++) {
            if (!this.missIndexes.get(i).equals(other.missIndexes.get(i))) {
                return Integer.compare(other.missIndexes.get(i), this.missIndexes.get(i));
            }
        }
        if (this.missIndexes.size() != other.missIndexes.size()) {
            return Integer.compare(this.missIndexes.size(), other.missIndexes.size());
        }
        return Integer.compare(this.id, other.id);
    }
}

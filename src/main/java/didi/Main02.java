package didi;
import java.util.*;

public class Main02 {

    static class Point {
        int x;
        int y;
        int steps;

        public Point(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = scanner.next();
            grid[i] = row.toCharArray();
        }

        int startX = scanner.nextInt();
        int startY = scanner.nextInt();
        int endXB = scanner.nextInt();
        int endYB = scanner.nextInt();
        int endXC = scanner.nextInt();
        int endYC = scanner.nextInt();

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        queue.offer(new Point(startX, startY, 0));
        visited[startX - 1][startY - 1] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == endXB && current.y == endYB) {
                System.out.println(current.steps);
                return;
            }

            for (int[] dir : directions) {
                int newX = current.x + dir[0];
                int newY = current.y + dir[1];

                if (newX >= 1 && newX <= n && newY >= 1 && newY <= m && grid[newX - 1][newY - 1] == '.' && !visited[newX - 1][newY - 1]) {
                    queue.offer(new Point(newX, newY, current.steps + 1));
                    visited[newX - 1][newY - 1] = true;
                }
            }
        }
    }
}

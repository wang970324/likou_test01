package huawei;

import java.util.*;

public class Main03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read car's maximum travel distance
        int M = Integer.parseInt(scanner.nextLine());

        // Read city count and fees
        String[] cityFees = scanner.nextLine().split(" ");
        int N = Integer.parseInt(cityFees[0]);
        int[] fees = new int[N];
        for (int i = 0; i < N; i++) {
            fees[i] = Integer.parseInt(cityFees[i + 1]);
        }

        // Read city connections
        int K = Integer.parseInt(scanner.nextLine());
        Map<Integer, List<Road>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < K; i++) {
            String[] connection = scanner.nextLine().split(" ");
            int city1 = Integer.parseInt(connection[0]);
            int city2 = Integer.parseInt(connection[1]);
            int distance = Integer.parseInt(connection[2]);
            graph.get(city1).add(new Road(new City(city2, fees[city2]), distance));
            graph.get(city2).add(new Road(new City(city1, fees[city1]), distance));
        }

        int result = findMinVisitCost(graph, M, N);
        System.out.println(result);
    }

    private static int findMinVisitCost(Map<Integer, List<Road>> graph, int maxDistance, int N) {
        PriorityQueue<City> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.distToStart));
        City start = new City(0, 0);
        start.distToStart = start.fee;
        pq.offer(start);

        while (!pq.isEmpty()) {
            City current = pq.poll();
            if (current.index == N - 1) {
                return current.distToStart;
            }
            for (Road road : graph.get(current.index)) {
                int nextDist = current.distToStart + road.target.fee;
                int nextDistance = road.distance;
                if (nextDist < road.target.distToStart && nextDistance <= maxDistance) {
                    road.target.distToStart = nextDist;
                    pq.offer(road.target);
                }
            }
        }

        return -1; // Unreachable
    }
}
class City {
    int index;
    int fee;
    int distToStart = Integer.MAX_VALUE; // Distance to start city

    City(int index, int fee) {
        this.index = index;
        this.fee = fee;
    }
}

class Road {
    City target;
    int distance;

    Road(City target, int distance) {
        this.target = target;
        this.distance = distance;
    }
}


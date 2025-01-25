package DSA.Graph.Djikstra;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CheapestFlights {
    static class Flight {
        int city, cost, stops;

        Flight(int city, int cost, int stops) {
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        // Build graph
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        // Queue for BFS: [city, cost, stops]
        Queue<Flight> queue = new LinkedList<>();
        queue.add(new Flight(src, 0, 0));

        // Store the minimum cost to reach each city with at most k stops
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        // BFS
        while (!queue.isEmpty()) {
            Flight current = queue.poll();
            int city = current.city;
            int cost = current.cost;
            int stops = current.stops;

            // Stop if the stop count exceeds K
            if (stops > k) continue;

            if (!graph.containsKey(city)) continue;

            for (int[] neighbor : graph.get(city)) {
                int nextCity = neighbor[0];
                int price = neighbor[1];

                int newCost = cost + price;

                // Only push to queue if the new cost is cheaper
                if (newCost < minCost[nextCity]) {
                    minCost[nextCity] = newCost;
                    queue.add(new Flight(nextCity, newCost, stops + 1));
                }
            }
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }

    public static void main(String[] args) {
        CheapestFlights solver = new CheapestFlights();
        int n = 4;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 3, 100},
                {0, 2, 500}
        };
        int src = 0, dst = 3, k = 1;

        // Example flight graph:
        // 0 --(100)-> 1 --(100)-> 2 --(100)-> 3
        //  \-----------------(500)------------/

        int result = solver.findCheapestPrice(n, flights, src, dst, k);
        System.out.println("Cheapest Price: " + result);
    }
}

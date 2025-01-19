package DSA.Graph.Djikstra;


import DSA.Graph.GraphNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
class CitiesWithSmallestNeighbours {


    public int smallestThreshold(int n, int[][] cities, int threshold) {
        Map<Integer, List<GraphNode>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] city : cities) {
            graph.get(city[0]).add(new GraphNode(city[1], city[2]));
            graph.get(city[1]).add(new GraphNode(city[0], city[2]));
        }

        // Iterate over each city to calculate reachable neighbors
        int minNeighborCount = Integer.MAX_VALUE;
        int cityWithSmallestNeighbour = -1;
        for (int i = 0; i < n; i++) {
            int city = i;
            int count = djikstra(n, threshold, graph, city);
            if (minNeighborCount > count ||
                    (count == minNeighborCount && city > cityWithSmallestNeighbour)) {// If there are multiple such cities, return the city with the greatest number.
                minNeighborCount = count;
                cityWithSmallestNeighbour = city;
            }
        }
        return cityWithSmallestNeighbour;
    }

    private static int djikstra(int n, int threshold, Map<Integer, List<GraphNode>> graph, int source) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[source] = 0;
        PriorityQueue<GraphNode> pq = new PriorityQueue<>();
        pq.add(new GraphNode(source, 0));
        while (!pq.isEmpty()) {
            GraphNode current = pq.poll();
            int src = current.dest;
            int dist = current.weight;

            if (cost[src] < dist) {
                continue;
            }

            for (GraphNode neighbour : graph.get(src)) {
                int newDest = neighbour.dest;
                int newDist = neighbour.weight;
                int candidateDist = newDist + cost[src];
                if (candidateDist < cost[newDest]) {
                    cost[newDest] = candidateDist;
                    pq.add(new GraphNode(newDest, cost[newDest]));
                }
            }
        }
        // count reachable neighbours within threshold
        int count = 0;
        for (int cityCost : cost) {
            if (cityCost <= threshold) {
                count++;
            }
        }
        return count - 1;// exclude city
    }

    public static void main(String[] args) {
        CitiesWithSmallestNeighbours sol = new CitiesWithSmallestNeighbours();
        int[][] cities1 = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int result = sol.smallestThreshold(4, cities1, 4);
        System.out.println("Smallest neighbor: " + result); // 3rd city

        int[][] cities2 = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        int result2 = sol.smallestThreshold(5, cities2, 2);// oth city
        System.out.println("Smallest neighbor: " + result2);
    }
}

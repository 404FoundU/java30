package DSA.Graph.Djikstra;

import DSA.Graph.GraphNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
public class NumberOfWaysToArrive {

    public int countPaths(int n, int[][] roads) {

        Map<Integer, List<GraphNode>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(new GraphNode(road[1], road[2]));
            graph.get(road[1]).add(new GraphNode(road[0], road[2]));

        }
        int finalDest = n - 1;
        int[] cost = new int[n];
        int[] ways = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;
        ways[0] = 1;

        PriorityQueue<GraphNode> pq = new PriorityQueue<>();
        pq.add(new GraphNode(0, 0));
        while (!pq.isEmpty()) {
            GraphNode current = pq.poll();
            int src = current.dest;
            int dist = current.weight;

            // have we already seen this
            int existingDistance = cost[src];
            if (existingDistance < dist) {
                continue;
            }


            for (GraphNode neighbour : graph.get(src)) {
                int newDest = neighbour.dest;
                int newDist = neighbour.weight;
                int candidateDist = dist + newDist;

                if (candidateDist < cost[newDest]) {
                    cost[newDest] = candidateDist;
                    pq.add(new GraphNode(newDest, candidateDist));
                    //     ways[newDest] =  1; but need to count from the previous source
                    ways[newDest] = ways[src];
                } else if (candidateDist == cost[newDest]) {
                    ways[newDest] += ways[src]; // count all the way from prev source
                }
            }

        }
        return ways[finalDest];
    }

    public static void main(String[] args) {
        NumberOfWaysToArrive solver = new NumberOfWaysToArrive();
        int n = 7;
        int[][] roads = {
                {0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3},
                {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1},
                {0, 4, 5}, {4, 6, 2}
        };


        System.out.println("Number of ways: " + solver.countPaths(n, roads)); // Output: 4
    }
}


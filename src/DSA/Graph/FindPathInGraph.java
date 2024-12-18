package DSA.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindPathInGraph {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create an adjacency list to represent the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Perform BFS to find if a path exists
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == destination) {
                return true;
            }

            for (int neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        FindPathInGraph solution = new FindPathInGraph();

        // Example 1
        // Graph representation:
        // 0 - 1
        // |   |
        // 2 - 3
        int n = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        int source = 0;
        int destination = 3;

        System.out.println(solution.validPath(n, edges, source, destination)); // Output: true

        // Example 2
        // Graph representation:
        // 0   1
        //  \ /
        //   2
        n = 3;
        edges = new int[][]{{0, 2}, {2, 1}};
        source = 0;
        destination = 1;

        System.out.println(solution.validPath(n, edges, source, destination)); // Output: true

        // Example 3
        // Graph representation:
        // 0   1
        n = 2;
        edges = new int[][]{};
        source = 0;
        destination = 1;

        System.out.println(solution.validPath(n, edges, source, destination)); // Output: false
    }
}


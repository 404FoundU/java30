package DSA.Graph.Djikstra;


import java.util.Arrays;


public class BellmanFordAlgorithm {

    public static void bellmanFord(int V, int[][] edges, int src) {
        int[] cost = new int[V];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        // Relax all edges (V - 1) times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];
                if (cost[u] != Integer.MAX_VALUE && cost[u] + weight < cost[v]) {
                    cost[v] = cost[u] + weight;
                }
            }
        }

        // Check for negative-weight cycles
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (cost[u] != Integer.MAX_VALUE && cost[u] + weight < cost[v]) {
                System.out.println("Graph contains a negative-weight cycle");
                return;
            }
        }

        // Print the shortest path from the source to each vertex
        System.out.println("Shortest Paths from Source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To vertex " + i + " cost: " + (cost[i] == Integer.MAX_VALUE ? "INF" : cost[i]));
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
                {0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {2, 4, 7}
        };

        System.out.println("Running Bellman-Ford Algorithm from Vertex 0:");
        bellmanFord(V, edges, 0);
    }
}

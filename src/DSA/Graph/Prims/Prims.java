package DSA.Graph.Prims;


import DSA.Graph.GraphNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prims {


    public static int[] primMST(List<List<GraphNode>> graph, int V) {
        boolean[] visited = new boolean[V];  // Tracks visited vertices
        int[] parent = new int[V];  // Store MST
        int[] key = new int[V];  // Minimum weights to connect vertices
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;  // Root of MST

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0}); // {weight, vertex}

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[1];

            if (visited[u]) continue;
            visited[u] = true;

            for (GraphNode edge : graph.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;

                if (!visited[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.offer(new int[]{key[v], v});
                    parent[v] = u;
                }
            }
        }
        return parent;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<GraphNode>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        int[][] edges = {
                {0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {2, 4, 7}
        };

        for (int[] edge : edges) {
            graph.get(edge[0]).add(new GraphNode(edge[1], edge[2]));
            graph.get(edge[1]).add(new GraphNode(edge[0], edge[2]));
        }

        int[] parent = primMST(graph, V);
        System.out.println("Minimum Spanning Tree (MST) GraphNodes:");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }
}

/*
Graph Visualization:
Vertices: 0, 1, 2, 3, 4
GraphNodes:
- 0 - 1 : weight 2
- 0 - 3 : weight 6
- 1 - 2 : weight 3
- 1 - 3 : weight 8
- 1 - 4 : weight 5
- 2 - 4 : weight 7

Minimum Spanning Tree (MST) edges:
- 0 - 1
- 1 - 2
- 1 - 4
- 0 - 3
*/

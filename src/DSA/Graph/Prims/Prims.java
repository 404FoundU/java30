package DSA.Graph.Prims;


import DSA.Graph.GraphNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=lg-HC6Q7kEE&t=589s
public class Prims {


    public static int[] primMST(Map<Integer, List<GraphNode>> graph, int V) {
        boolean[] visited = new boolean[V];  // Tracks visited vertices
        int[] parent = new int[V];  // Store MST
        int[] cost = new int[V];  // Minimum weights to connect vertices
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;
        parent[0] = -1;  // Root of MST

        PriorityQueue<GraphNode> pq = new PriorityQueue<>();
        pq.offer(new GraphNode(0, 0)); // {vertex, weight}

        while (!pq.isEmpty()) {
            GraphNode curr = pq.poll();
            int src = curr.dest;

            if (visited[src]) continue;
            visited[src] = true;

            for (GraphNode neighbour : graph.get(src)) {
                int newDest = neighbour.dest;
                int newWeight = neighbour.weight;

                if (newWeight < cost[newDest]) {
                    if (!visited[newDest]) {
                        cost[newDest] = newWeight;
                        pq.offer(new GraphNode(newDest, cost[newDest]));
                        parent[newDest] = src;
                    }
                }
            }
        }
        return parent;
    }

    public static void main(String[] args) {
        int V = 5;
        Map<Integer, List<GraphNode>> graph = new HashMap<>();
        for (int i = 0; i < V; i++) {
            graph.put(i, new ArrayList<>());
        }

        int[][] edges = {
                {0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {2, 4, 7}
        };

        for (int[] edge : edges) {
            graph.get(edge[0]).add(new GraphNode(edge[1], edge[2]));
            graph.get(edge[1]).add(new GraphNode(edge[0], edge[2]));
        }

        int[] parent = primMST(graph, V);
        System.out.println("Minimum Spanning Tree (MST) Edges:");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }
}

/*
Graph Visualization:
Vertices: 0, 1, 2, 3, 4
Edges:
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

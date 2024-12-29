package DSA.Graph.Djikstra;


import DSA.Graph.GraphNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class DijkstrasAlgorithm {
    public static void dijkstra(Map<Integer, List<GraphNode>> graph, int V, int src) {
        int[] cost = new int[V];
        int[] parent = new int[V];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        parent[src] = -1;

        PriorityQueue<GraphNode> pq = new PriorityQueue<>();
        pq.offer(new GraphNode(src, 0));

        while (!pq.isEmpty()) {
            GraphNode curr = pq.poll();
            int source = curr.dest;

            for (GraphNode neighbour : graph.get(source)) {
                int newDest = neighbour.dest;
                int weight = neighbour.weight;

                int candidateWeight = cost[source] + weight;
                if (candidateWeight < cost[newDest]) {
                    cost[newDest] = candidateWeight;
                    pq.offer(new GraphNode(newDest, cost[newDest]));
                    parent[newDest] = source;
                }
            }
        }

        System.out.println("Shortest Paths from Source " + src + ":");
        for (int i = 0; i < V; i++) {
            if (i != src) {
                System.out.print("Path to " + i + ": ");
                printPath(i, parent);
                System.out.println(" (Cost: " + cost[i] + ")");
            }
        }

    }

    public static void printPath(int node, int[] parent) {
        if (node == -1) return;
        printPath(parent[node], parent);
        System.out.print(node + " ");
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


        System.out.println("\nRunning Dijkstra's Algorithm from Vertex 0:");
        DijkstrasAlgorithm.dijkstra(graph, V, 0);
    }
}


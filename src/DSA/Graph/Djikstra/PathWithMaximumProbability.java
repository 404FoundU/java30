package DSA.Graph.Djikstra;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/path-with-maximum-probability/
public class PathWithMaximumProbability {

    static class GraphNode {
        int node;
        double probability;

        public GraphNode(int node, double probability) {
            this.node = node;
            this.probability = probability;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<GraphNode>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            // need to put only single direction since we are going from start to end.
            graph.get(edge[0]).add(new GraphNode(edge[1], succProb[i]));
        }
        double[] cost = new double[n];
        Arrays.fill(cost, 0.0);
        cost[start] = 1.0;

        // Path with longest - reverese djikstra
        PriorityQueue<GraphNode> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));
        pq.add(new GraphNode(start, 1.0));

        while (!pq.isEmpty()) {
            GraphNode current = pq.poll();
            int src = current.node;
            double prob = current.probability;


            if (src == end) {
                return prob;
            }
            if (cost[src] > prob) {
                continue;
            }

            for (GraphNode neighbour : graph.get(src)) {
                int newSrc = neighbour.node;
                double newProb = neighbour.probability;
                double candidateProb = prob * newProb;
                if (candidateProb > cost[newSrc]) {
                    cost[newSrc] = candidateProb;
                    pq.add(new GraphNode(newSrc, cost[newSrc]));
                }
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        PathWithMaximumProbability solver = new PathWithMaximumProbability();

        int n = 3;
        int[][] edges = {
                {0, 1}, {1, 2}, {0, 2}
        };
        double[] succProb = {0.5, 0.5, 0.2};
        int start = 0;
        int end = 2;

        System.out.println("Maximum Probability: " + solver.maxProbability(n, edges, succProb, start, end)); // Output: 0.25
    }
    /*
• Time Complexity:
	• O(ElogV)
		○ E: Number of edges (relaxation steps).
		○ logV: Priority queue operations.
• Space Complexity:
	• O(V+E)
For the graph and the priority queue.
     */
}

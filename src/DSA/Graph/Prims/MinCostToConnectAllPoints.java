package DSA.Graph.Prims;


import DSA.Graph.GraphNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=8VPIrqwQ8sQ&list=PLKYEe2WisBTHCmJ6IfEMjg8o--Bvfc5gt&index=9
public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {

        int length = points.length;
        int[] cost = new int[length];
        Arrays.fill(cost, Integer.MAX_VALUE);
        int[] parent = new int[length];
        boolean[] visited = new boolean[length];
        Map<Integer, List<GraphNode>> graph = new HashMap<>();

        for (int i = 0; i < length; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = 1; j < points.length; j++) {
                //|xi - xj| + |yi - yj|,

                int xi = points[i][0];
                int xj = points[j][0];
                int yi = points[i][1];
                int yj = points[j][1];
                int weight = Math.abs(xi - xj) + Math.abs(yi - yj);
                graph.get(i).add(new GraphNode(j, weight)); // X->Y
                graph.get(j).add(new GraphNode(i, weight));// Y->X
            }
        }

        cost[0] = 0;
        parent[0] = -1;

        PriorityQueue<GraphNode> pq = new PriorityQueue<>();
        pq.add(new GraphNode(0, 0));

        while (!pq.isEmpty()) {
            GraphNode current = pq.poll();
            int src = current.dest;
            int d = current.weight;

            if (visited[src]) {
                continue;
            }
            visited[src] = true;
            for (GraphNode neighbour : graph.get(src)) {
                int newDest = neighbour.dest;
                int newWeight = neighbour.weight;
                if (newWeight < cost[newDest]) {
                    if (!visited[newDest]) {
                        cost[newDest] = newWeight;
                        pq.add(new GraphNode(newDest, cost[newDest]));
                        parent[newDest] = src;
                    }
                }


            }
        }
        int totalCost = 0;
        for (int i = 0; i < points.length; i++) { // cost[0] = 0
            totalCost += cost[i];
        }
        return totalCost;
    }

    public static void main(String[] args) {
        MinCostToConnectAllPoints solver = new MinCostToConnectAllPoints();
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        int result = solver.minCostConnectPoints(points);
        System.out.println("Minimum cost to connect all points: " + result);
    }
}

/*
Tree Diagram (Conceptual for example case):

Points: (0,0), (2,2), (3,10), (5,2), (7,0)
Edges in MST (Manhattan distances):
(0,0) -- 4 -- (2,2)
(2,2) -- 3 -- (5,2)
(5,2) -- 2 -- (7,0)
(2,2) -- 8 -- (3,10)
Total Cost = 4 + 3 + 2 + 8 = 17
*/






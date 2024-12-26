package DSA.Graph.Djikstra;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class NetworkDelayTime {


    public int networkDelayTime(int[][] times, int noOfVertices, int source) {
        Map<Integer, List<GraphNode>> graph = new HashMap<>();
        for (int i = 1; i <= noOfVertices; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            int src = time[0];
            int dest = time[1];
            int t = time[2];
            graph.get(src).add(new GraphNode(dest, t));
        }
        int[] dist = new int[noOfVertices + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<GraphNode> pq = new PriorityQueue<>();
        pq.add(new GraphNode(source, 0));

        while (!pq.isEmpty()) {
            GraphNode current = pq.poll();
            int src = current.vertex;
            int t = current.distance;

            int existingTime = dist[src];
            if (existingTime < t) {
                continue;
            }

            for (GraphNode neighbour : graph.get(src)) {
                int dest = neighbour.vertex;
                int travelTime = neighbour.distance;

                int candidateDistance = dist[src] + travelTime;
                if (candidateDistance < dist[dest]) {
                    dist[dest] = candidateDistance;
                    pq.add(new GraphNode(dest, dist[dest]));
                }
            }
        }
        int maxTime = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }

    public static void main(String[] args) {
        NetworkDelayTime sol = new NetworkDelayTime();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
        int result = sol.networkDelayTime(times, n, k);
        System.out.println("Network Delay Time: " + result);
    }
}

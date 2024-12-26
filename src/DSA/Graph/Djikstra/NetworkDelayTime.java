package DSA.Graph.Djikstra;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/network-delay-time/
//https://www.youtube.com/watch?v=Bp7STMWMMQw&list=PLKYEe2WisBTHCmJ6IfEMjg8o--Bvfc5gt&index=10
/*
Djikstra has a graph node and a distance array.
 */
class NetworkDelayTime {


    public int networkDelayTime(int[][] distances, int noOfVertices, int source) {
        Map<Integer, List<GraphNode>> graph = new HashMap<>();
        for (int i = 1; i <= noOfVertices; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] distance : distances) {
            int src = distance[0];
            int dist = distance[1];
            int t = distance[2];
            graph.get(src).add(new GraphNode(dist, t));
        }
        int[] distArray = new int[noOfVertices + 1];
        Arrays.fill(distArray, Integer.MAX_VALUE);
        distArray[source] = 0;

        PriorityQueue<GraphNode> pq = new PriorityQueue<>();
        pq.add(new GraphNode(source, 0));

        while (!pq.isEmpty()) {
            GraphNode current = pq.poll();
            int src = current.vertex;
            int d = current.distance;

            int existingDistance = distArray[src];
            if (existingDistance < d) {
                continue;
            }

            for (GraphNode neighbour : graph.get(src)) {
                int dest = neighbour.vertex;
                int travelDistance = neighbour.distance;

                int candidateDistance = distArray[src] + travelDistance;
                int previousDistance = distArray[dest];
                if (candidateDistance < previousDistance) {
                    distArray[dest] = candidateDistance;
                    pq.add(new GraphNode(dest, distArray[dest]));
                }
            }
        }

        // get the maximum in distArray
        int maxDistance = 0;
        for (int i = 1; i < distArray.length; i++) {

            // if there are nodes that cannot be reached
            if (distArray[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxDistance = Math.max(maxDistance, distArray[i]);
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        NetworkDelayTime sol = new NetworkDelayTime();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
        int result = sol.networkDelayTime(times, n, k);
        System.out.println("Network Delay Time: " + result);
    }
}

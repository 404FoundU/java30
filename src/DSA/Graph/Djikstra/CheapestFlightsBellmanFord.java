package DSA.Graph.Djikstra;


import java.util.Arrays;

class GraphNode {
    int dest, weight;

    public GraphNode(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

public class CheapestFlightsBellmanFord {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        // Relax all edges up to k + 1 times (k stops means k+1 edges)
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(cost, n);
            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int price = flight[2];
                if (cost[u] != Integer.MAX_VALUE && cost[u] + price < temp[v]) {
                    temp[v] = cost[u] + price;
                }
            }
            cost = temp;
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
                {0, 1, 100}, {1, 2, 100}, {2, 3, 100}, {0, 2, 500}
        };
        int src = 0, dst = 3, k = 1;

        System.out.println("Cheapest Price within " + k + " stops: " + findCheapestPrice(n, flights, src, dst, k));
    }
}

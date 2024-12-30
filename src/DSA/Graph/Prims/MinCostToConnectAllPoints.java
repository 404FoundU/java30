package DSA.Graph.Prims;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] inMST = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        int totalCost = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0});

        int edgesUsed = 0;
        while (edgesUsed < n) {
            int[] node = pq.poll();
            int currNode = node[0];
            int currDist = node[1];

            if (inMST[currNode]) continue;

            inMST[currNode] = true;
            totalCost += currDist;
            edgesUsed++;

            for (int nextNode = 0; nextNode < n; nextNode++) {
                if (!inMST[nextNode]) {
                    int nextDist = Math.abs(points[currNode][0] - points[nextNode][0]) +
                            Math.abs(points[currNode][1] - points[nextNode][1]);
                    if (nextDist < minDist[nextNode]) {
                        minDist[nextNode] = nextDist;
                        pq.offer(new int[]{nextNode, nextDist});
                    }
                }
            }
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






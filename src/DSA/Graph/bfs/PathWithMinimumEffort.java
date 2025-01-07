package DSA.Graph.bfs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/path-with-minimum-effort/description/?envType=problem-list-v2&envId=9id9smj2
public class PathWithMinimumEffort {

    private static final int[][] DIRECTIONS = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] cost = new int[m][n];

        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> cost[a[0]][a[1]]));
        pq.add(new int[]{0, 0}); // Start at top-left corner
        cost[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int row = current[0];
            int col = current[1];

            if (row == m - 1 && col == n - 1) {
                return cost[row][col];
            }

            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];

                if (r >= 0 && c >= 0 && r < m && c < n) {
                    int effortToNeighbor = Math.abs(heights[r][c] - heights[row][col]);
                    int maxEffortSoFar = Math.max(cost[row][col], effortToNeighbor);

                    if (maxEffortSoFar < cost[r][c]) {
                        cost[r][c] = maxEffortSoFar;
                        pq.add(new int[]{r, c});
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        PathWithMinimumEffort solver = new PathWithMinimumEffort();
        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        System.out.println("Minimum Effort Path: " + solver.minimumEffortPath(heights)); // Output: 2
    }
}

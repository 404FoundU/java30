package DSA.Graph.bfs;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] efforts = new int[rows][cols];

        for (int[] row : efforts) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0});  // Start from (0,0) with 0 effort
        efforts[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0], y = current[1], effort = current[2];

            if (x == rows - 1 && y == cols - 1) {
                return effort;  // Reached destination
            }

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newY >= 0 && newX < rows && newY < cols) {
                    int newEffort = Math.max(effort, Math.abs(heights[newX][newY] - heights[x][y]));
                    if (newEffort < efforts[newX][newY]) {
                        efforts[newX][newY] = newEffort;
                        pq.offer(new int[]{newX, newY, newEffort});
                    }
                }
            }
        }

        return 0;  // Unreachable case (should not happen)
    }

    public static void main(String[] args) {
        PathWithMinimumEffort solver = new PathWithMinimumEffort();
        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        System.out.println("Minimum Effort Path: " + solver.minimumEffortPath(heights));  // Output: 2
    }
}

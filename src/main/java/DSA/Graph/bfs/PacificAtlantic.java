package DSA.Graph.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.youtube.com/watch?v=pDvvDvgHUKE&list=PLKYEe2WisBTHCmJ6IfEMjg8o--Bvfc5gt&index=6
public class PacificAtlantic {

    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 4 possible directions

    public static List<List<Integer>> pacificAtlantic(int[][] grid) {
        List<List<Integer>> result = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) return result;

        int m = grid.length;
        int n = grid[0].length;

        // Boolean matrices to track cells reachable by each ocean
        boolean[][] pacificReachable = new boolean[m][n];
        boolean[][] atlanticReachable = new boolean[m][n];

        // Initialize BFS for Pacific (left and top borders)
        Queue<int[]> pacificQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            pacificQueue.add(new int[]{i, 0}); // Left border
            pacificReachable[i][0] = true;
        }
        for (int j = 0; j < n; j++) {
            pacificQueue.add(new int[]{0, j}); // Top border
            pacificReachable[0][j] = true;
        }

        // Initialize BFS for Atlantic (right and bottom borders)
        Queue<int[]> atlanticQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            atlanticQueue.offer(new int[]{i, n - 1}); // Right border
            atlanticReachable[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            atlanticQueue.offer(new int[]{m - 1, j}); // Bottom border
            atlanticReachable[m - 1][j] = true;
        }

        // Perform BFS for both oceans
        bfs(grid, pacificQueue, pacificReachable);
        bfs(grid, atlanticQueue, atlanticReachable);

        // Find all cells that can reach both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private static void bfs(int[][] grid, Queue<int[]> queue, boolean[][] reachable) {
        int m = grid.length;
        int n = grid[0].length;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            // Explore neighbors in all four directions
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];

                // Check bounds, whether the neighbor is reachable, and if it has an equal or higher height
                if (r >= 0 && r < m && c >= 0 && c < n &&
                        grid[r][c] >= grid[row][col]) {
                    if (reachable[r][c] == false) {
                        reachable[r][c] = true; // Mark as reachable
                        queue.add(new int[]{r, c}); // Add to queue for further exploration
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        List<List<Integer>> result = pacificAtlantic(heights);
        System.out.println("Cells that can reach both Pacific and Atlantic oceans: " + result);
    }
}

package DSA.Graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/max-area-of-island/description/
public class MaxAreaOfIsland {

    // Define the 4 possible directions (up, down, left, right)
    private static final int[][] DIRECTIONS = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // Start a BFS when a new island (1) is found
                if (grid[i][j] == 1) {
                    int newArea = bfs(grid, i, j);
                    maxArea = Math.max(maxArea, newArea);
                }
            }
        }

        return maxArea;
    }

    // BFS to calculate area of the island starting from (i, j)
    private static int bfs(int[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = 0; // Mark as visited by setting it to '0'
        int area = 1; // Initial area for the current land cell

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            // Check all 4 possible directions (up, down, left, right)
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];

                // Check if the new position is within bounds and is land ('1')
                if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
                    queue.add(new int[]{r, c});
                    grid[r][c] = 0; // Mark as visited by setting it to '0'
                    area++; // Increase area for each connected land cell
                }
            }
        }

        return area;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {0, 0, 1, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 1, 0, 0},
                {1, 1, 0, 0, 0}
        };

        int[][] grid2 = {
                {0, 1},
                {1, 1}
        };

        System.out.println("Max Area in grid1: " + maxAreaOfIsland(grid1)); // Output: 5
        System.out.println("Max Area in grid2: " + maxAreaOfIsland(grid2)); // Output: 3
    }
}


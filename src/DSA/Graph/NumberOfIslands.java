package DSA.Graph;

import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=gCswsDauXPc&list=PLKYEe2WisBTHCmJ6IfEMjg8o--Bvfc5gt&index=2
public class NumberOfIslands {


    // Define the 4 possible directions (up, down, left, right)
    private static final int[][] DIRECTIONS = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int numIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // If we find land ('1'), start a BFS to mark the whole island
                if (grid[i][j] == '1') {
                    numIslands++; // New island found
                    bfs(grid, i, j); // Perform BFS to mark all adjacent lands
                }
            }
        }

        return numIslands;
    }

    // BFS to mark all cells of the island starting from (i, j)
    private static void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = '0'; // Mark the starting cell as visited by setting it to '0'

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            // Check all 4 possible directions (up, down, left, right)
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];

                // Check if the new position is within bounds and is land ('1')
                int m = grid.length;
                int n = grid[0].length;
                if (r >= 0 && r < m && c >= 0 && c < n) {
                    if (grid[r][c] == '1') {
                        queue.add(new int[]{r, c});
                        grid[r][c] = '0'; // Mark as visited by setting it to '0'
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println("Number of islands in grid1: " + numIslands(grid1)); // Output: 1
        System.out.println("Number of islands in grid2: " + numIslands(grid2)); // Output: 3
    }
}





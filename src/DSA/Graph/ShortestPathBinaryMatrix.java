package DSA.Graph;

import java.util.LinkedList;
import java.util.Queue;


//https://www.youtube.com/watch?v=CABaqOkWbgQ
public class ShortestPathBinaryMatrix {

    private static final int[][] DIRECTIONS = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}, // up, down, left, right
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1} // diagonals: top-left, top-right, bottom-left, bottom-right

    };

    public static int shortestPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // Start from the top-left corner with path length 1

        grid[0][0] = 1;// visited
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int distance = current[2];

            // Check if we've reached the bottom-right corner
            if (row == n - 1 && col == n - 1) { // 2,2
                return distance;
            }

            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];

                // Check if new position is within bounds and is an open cell
                if (r >= 0 && c >= 0 && r < m && c < n) {
                    if (grid[r][c] == 0) {
                        queue.add(new int[]{r, c, distance + 1});
                        grid[r][c] = 1;// visited

                    }
                }
            }


        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {0, 1},
                {1, 0}
        };

        int[][] grid2 = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };

        System.out.println("Shortest Path in grid1: " + shortestPath(grid1)); // Output: 2
        System.out.println("Shortest Path in grid2: " + shortestPath(grid2)); // Output: 4
    }
}

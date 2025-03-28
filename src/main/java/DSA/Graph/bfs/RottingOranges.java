package DSA.Graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/description/
public class RottingOranges {

    // Define the 4 possible directions (up, down, left, right)
    private static final int[][] DIRECTIONS = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        return bfs(grid);
    }

    private int bfs(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // calculate fresh oranges
        // add first rotten orange to queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }

        int minutes = 0;
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            // finish all at the level
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int row = point[0];
                int col = point[1];

                for (int[] direction : DIRECTIONS) {
                    int r = row + direction[0];
                    int c = col + direction[1];

                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        if (grid[r][c] == 1) {
                            grid[r][c] = 2;
                            queue.add(new int[]{r, c});
                            freshOranges--;
                        }
                    }
                }
            }
            minutes++;
        }

        return freshOranges == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        RottingOranges solution = new RottingOranges();
        int result = solution.orangesRotting(grid);
        System.out.println("Minutes until all oranges are rotten: " + result);
    }
}


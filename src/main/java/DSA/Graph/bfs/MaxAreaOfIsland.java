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
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = bfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);

                }
            }
        }
        return maxArea;
    }

    // BFS to calculate area of the island starting from (i, j)
    private static int bfs(int[][] grid, int i, int j) {

        int m = grid.length;
        int n = grid[0].length;
        int[] source = new int[]{i, j};
        Queue<int[]> q = new LinkedList<>();
        q.add(source);
        grid[i][j] = 0;
        int area = 1;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];

                if (r >= 0 && r < m && c >= 0 && c < n) {
                    if (grid[r][c] != 0) {
                        area++;
                        q.add((new int[]{r, c}));
                        grid[r][c] = 0;
                    }
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


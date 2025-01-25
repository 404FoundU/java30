package DSA.Graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=gCswsDauXPc&list=PLKYEe2WisBTHCmJ6IfEMjg8o--Bvfc5gt&index=2
public class NumberOfIslands { // O( mxn)


    // Define the 4 possible directions (up, down, left, right)
    private static final int[][] DIRECTIONS = { // r,c = (r-1,c) (r+1,c), (r, c-1) (r, c+1 )
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length; // row m x n adjacency Matrix
        int n = grid[0].length; // col

        int numOfIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    // BFS to mark all cells of the island as 0 starting from (i, j)
    private static void bfs(char[][] grid, int i, int j) {
        int m = grid.length; // row m x n adjacency Matrix
        int n = grid[0].length; // col
        Queue<int[]> q = new LinkedList<>();
        int[] source = new int[]{i, j};
        q.add(source);
        grid[i][j] = '0';// mark as visited
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];

            // check adjacent cells
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];

                //check boundary
                if (r >= 0 && r < m && c >= 0 && c < n) {
                    if (grid[r][c] != '0') {
                        q.add(new int[]{r, c});
                        grid[r][c] = '0';
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





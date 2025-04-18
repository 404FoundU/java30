package DSA.Graph.dfs;

//https://www.youtube.com/watch?v=gCswsDauXPc&list=PLKYEe2WisBTHCmJ6IfEMjg8o--Bvfc5gt&index=2
public class NumberOfIslandsDfs { // O( mxn)
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length; // row m x n adjacency Matrix
        int n = grid[0].length; // col

        boolean[][] visited = new boolean[m][n];
        int numOfIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    dfs(grid, i, j, visited);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    private static void dfs(char[][] grid, int r, int c, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return;
        }
        if (visited[r][c]) {
            return;
        }
        if (grid[r][c] == '0') {
            return;
        }
        visited[r][c] = true;
        dfs(grid, r + 1, c, visited);
        dfs(grid, r - 1, c, visited);
        dfs(grid, r, c + 1, visited);
        dfs(grid, r, c - 1, visited);

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





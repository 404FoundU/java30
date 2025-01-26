package DSA.Graph.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MineSweeper {

    private static final int[][] DIRECTIONS = {
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1} // 8 directions
    };

    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;

        int row = click[0];
        int col = click[1];

        // If the clicked cell is a mine, mark it as 'X' and return the board
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }

        // BFS to reveal cells
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            // Skip if the cell is already revealed
            if (board[r][c] != 'E') continue;

            // Count adjacent mines
            int mines = countAdjacentMines(board, r, c);

            if (mines > 0) {
                // If there are adjacent mines, update the cell with the mine count
                board[r][c] = (char) ('0' + mines);
            } else {
                // If no adjacent mines, mark as 'B' and add adjacent cells to the queue
                board[r][c] = 'B';
                for (int[] dir : DIRECTIONS) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'E') {
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }

        return board;
    }

    // Helper method to count adjacent mines
    private int countAdjacentMines(char[][] board, int r, int c) {
        int count = 0;
        for (int[] dir : DIRECTIONS) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 'M') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MineSweeper solution = new MineSweeper();

        char[][] board1 = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };
        int[] click1 = {3, 0};
        char[][] result1 = solution.updateBoard(board1, click1);
        for (char[] row : result1) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println();

        char[][] board2 = {
                {'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}
        };
        int[] click2 = {1, 2};
        char[][] result2 = solution.updateBoard(board2, click2);
        for (char[] row : result2) {
            System.out.println(Arrays.toString(row));
        }
    }
}


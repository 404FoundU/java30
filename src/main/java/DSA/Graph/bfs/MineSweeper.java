package DSA.Graph.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MineSweeper {

    private static final int[][] DIRECTIONS = {
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1} // 8 directions
    };

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return board; // Handle edge case of empty board
        }

        int m = board.length;
        int n = board[0].length;
        int x = click[0];
        int y = click[1];

        // If the clicked cell is a mine, mark it as 'X' and return the board
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        // BFS to reveal cells
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            // Skip if the cell is not unrevealed
            if (board[row][col] != 'E') continue; //// E- unrevealed empty square
            // if we did not click on a mine we have to reveal it as empty or count
            int mines = countAdjacentMines(board, row, col);

            if (mines > 0) {
                // If there are adjacent mines, update the cell with the mine count
                board[row][col] = (char) ('0' + mines);// store as char
            } else {
                // we clicked on empty , mark as Blank and add all unrevealed adjacent cells to queue
                board[row][col] = 'B';
                for (int[] dir : DIRECTIONS) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r >= 0 && r < m && c >= 0 && c < n) {
                        if (board[r][c] == 'E') {
                            queue.add(new int[]{r, c});
                        }
                    }
                }
            }
        }

        return board;
    }

    // count the number of mines around row,col
    private int countAdjacentMines(char[][] board, int row, int col) {
        int count = 0;
        for (int[] dir : DIRECTIONS) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
                if (board[r][c] == 'M') {
                    count++;
                }
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



package DSA.RecursionBacktracking;

//https://www.youtube.com/watch?v=m9TrOL1ETxI
//https://leetcode.com/problems/word-search/
public class WordSearchBT2 {


    public static void main(String[] args) {
        char[][] board = {
                {'B', 'L', 'C', 'H'},
                {'D', 'E', 'L', 'T'},
                {'D', 'A', 'K', 'A'},
        };


        String word = "BLEAK";
        boolean search = search(board, word);
        System.out.println(search);
    }

    public static boolean search(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final int[][] DIRECTIONS = {
            {1, 0},   // down
//            {-1, 0},  // up
            {0, 1},   // right
//            {0, -1}   // left
    };
    public static boolean backtrack(char[][] board, String word,
                                    int row, int col, int start) {
        if (start == word.length()) { // reached goal
            //add to result

            // return
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (board[row][col] != word.charAt(start)) {
            return false;
        }

        // make choice
        char temp = board[row][col];
        board[row][col] = '#'; // mark visited
        for (int[] dir : DIRECTIONS) {
            int r = row + dir[0];
            int c = col + dir[1];

            if (backtrack(board, word, r, c, start + 1)) {
                return true;
            }
        }

        // undo choice
        board[row][col] = temp;
        return false;
    }
}

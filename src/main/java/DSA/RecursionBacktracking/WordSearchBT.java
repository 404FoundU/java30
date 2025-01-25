package DSA.RecursionBacktracking;

//https://www.youtube.com/watch?v=m9TrOL1ETxI
public class WordSearchBT {

    static boolean[][] visited;

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
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Start backtracking from each cell
                if (word.charAt(0) == board[i][j] && backtrack(board, word, i, j, 0)) {
                    return true; // Word found
                }
            }
        }
        return false; // Word not found
    }

    public static boolean backtrack(char[][] board, String word,
                                    int row, int col, int index) {
        // Check if we found the whole word
        if (index == word.length()) { // goal reached
            return true;
        }

        //check boundaries and character match
        if (row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length ||
                board[row][col] != word.charAt(index)
        ) {
            return false;
        }

        visited[row][col] = true;// make choice

        // Explore neighbors (up, down, left, right)
//backtrack
        if (backtrack(board, word, row + 1, col, index + 1) || // Down
                backtrack(board, word, row - 1, col, index + 1) || // Up
                backtrack(board, word, row, col + 1, index + 1) || // Right
                backtrack(board, word, row, col - 1, index + 1)   // Left
        ) {
            return true;
        }
        visited[row][col] = false;//undo choice

        return false;
    }
}

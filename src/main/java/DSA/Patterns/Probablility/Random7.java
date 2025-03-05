package DSA.Patterns.Probablility;

import java.util.Random;

//https://www.youtube.com/watch?v=S_jLDKSmxSo
class Random7 {
    private int[][] table; // 7x7 lookup table

    // Given function rand7() that generates a random integer from 1 to 7
    public int rand7() {
        Random rand = new Random();
        return rand.nextInt(7) + 1; // Generates a number between 1 and 7
    }

    // Constructor to initialize the lookup table
    public Random7() {
        table = new int[7][7]; // 7x7 matrix
        int n = 0;
        for (int r = 0; r < 7; r++) {
            for (int c = 0; c < 7; c++) {
                table[r][c] = n % 10; // Fill with values 0-9 cyclically
                n++;
            }
        }
    }

    // Function to generate rand10() using rand7()
    public int rand10() {
        while (true) {
            int row = rand7() - 1; // Convert to 0-based index
            int col = rand7() - 1; // Convert to 0-based index
            if (row == 6 || (row == 5 && col > 5)) {
                continue; // Discard invalid numbers (41-49)
            }
            return table[row][col] + 1; // Convert back to 1-10 range
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Random7 solution = new Random7();
        int[] count = new int[11]; // Frequency counter for numbers 1-10

        // Simulating 1000000 calls to rand10()
        for (int i = 0; i < 1000000; i++) {
            int val = solution.rand10();
            count[val]++;
        }

        // Display frequency distribution
        System.out.println("Frequency distribution of rand10():");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + ": " + count[i]);
        }
    }
}

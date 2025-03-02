package DSA.Dynamic;

import java.util.Arrays;

// given the size m * n of a grid. Travel from 0,0 to m-1,n-1.
// How many ways can you travel
public class GridTravellerTabulation {
    public static void main(String[] args) {

        System.out.println(gridTraveller(1, 1)); //1
        System.out.println(gridTraveller(2, 3)); //3
        System.out.println(gridTraveller(3, 2)); // 3
        System.out.println(gridTraveller(3, 3)); // 6
        System.out.println(gridTraveller(18, 18));
    }

    private static int gridTraveller(int m, int n) {
        int[][] table = new int[m + 1][n + 1];
        for (int[] row : table) {
            Arrays.fill(row, 0);
        }
        table[1][1] = 1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i + 1 <= m) { // check bounds
                    table[i + 1][j] += table[i][j];
                }
                if (j + 1 <= n) {
                    table[i][j + 1] += table[i][j];
                }
            }
        }

        return table[m][n];
    }
}
    /*
• visualize the problem as a table
• size the table based on the inputs
• initialize the table with default values ( boolean or int )
• seed the trivial answer into the table
• iterate through the table
• fill further positions based on the current position ( find the algorithm )
    * */



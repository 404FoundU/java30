package DSA.Patterns.Prefix;

/*
https://leetcode.com/problems/range-sum-query-2d-immutable/
https://www.youtube.com/watch?v=LsyVvdlXLSM
 */

public class RangeSumQuery2D {
    private int[][] prefixSum;

    public RangeSumQuery2D(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Initialize padded prefixSum array (extra row and column)
        prefixSum = new int[m + 1][n + 1];

        // Step 1: Row-wise prefix sum
        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                prefixSum[r][c] = prefixSum[r][c - 1] + matrix[r - 1][c - 1];
            }
        }

        // Step 2: Column-wise prefix sum on top of row prefix
        for (int c = 1; c <= n; c++) {
            for (int r = 1; r <= m; r++) {
                prefixSum[r][c] += prefixSum[r - 1][c];
            }
        }
    }

    // Return sum of submatrix from (row1, col1) to (row2, col2)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // Use +1 due to padding
        return prefixSum[row2 + 1][col2 + 1]
                - prefixSum[row1][col2 + 1]
                - prefixSum[row2 + 1][col1]
                + prefixSum[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        RangeSumQuery2D numMatrix = new RangeSumQuery2D(matrix);

        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // Output: 8
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // Output: 11
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // Output: 12
    }


    /*

prefix =
[
  [ 0,  0,  0,  0,  0,  0],  ← row 0 (padding)
  [ 0,  3,  3,  4,  8, 10],  ← row 1
  [ 0,  8, 14, 18, 24, 27],  ← row 2
  [ 0,  9, 17, 21, 28, 36],  ← row 3
  [ 0, 13, 22, 26, 34, 49],  ← row 4
  [ 0, 14, 23, 30, 38, 58]   ← row 5
]


= prefix[5][4]  // 38
- prefix[2][4]  // 24
- prefix[5][1]  // 14
+ prefix[2][1]  // 8
= 38 - 24 - 14 + 8 = 8 ✅

    prefix:
   c0  c1  c2  c3  c4  c5
r0 [ 0,  0,  0,  0,  0,  0 ]
r1 [ 0,  3,  3,  4,  8, 10 ]
r2 [ 0,  8, 14, 18, 24, 27 ]
r3 [ 0,  9, 17, 21, 28, 36 ]
r4 [ 0, 13, 22, 26, 34, 49 ]
r5 [ 0, 14, 23, 30, 38, 58 ]
     ↑           ↑
   r1=2        r2+1=5
     |___________|
     |           |
   c1=1       c2+1=4

     */
}

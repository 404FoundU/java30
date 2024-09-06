package DSA.Arrays;

import java.util.Arrays;

//leetcode 48
//https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/lecture/23992650#overview
public class MatrixRotate {
    public static void main(String[] args) {
        MatrixRotate test = new MatrixRotate();
        int[][] intArr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

//        test.inPlaceRotate(intArr);
        test.transpose(intArr);
        System.out.println(Arrays.deepToString(intArr));
    }

    //https://www.youtube.com/watch?v=-jhbxNJijyE
    private void transpose(int[][] a) {
        int n = a.length;

        // transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        //swap reflection
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) { // run swap only till half
                int temp = a[i][j];
                a[i][j] = a[i][n - 1 - j];// 2 pointer from left and right
                a[i][n - 1 - j] = temp;
            }
        }
    }

    //https://www.youtube.com/watch?v=Ux058jpRB9Y&t=330s
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        for (int i = 0; i < (n + 1) / 2; i++) {

            for (int j = 0; j < n / 2; j++) {
                // Start 4 way swaps
                // temp = bottom left
                int temp = matrix[n - 1 - j][i];

                // bottom left = bottom right
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];

                // bottom right = top right
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];

                // top right = top left
                matrix[j][n - 1 - i] = matrix[i][j];

                // top left = temp
                matrix[i][j] = temp;
            }
        }
    }


}

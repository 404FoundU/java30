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


    private void inPlaceRotate(int[][] a) {
        int n = a.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int col = first; col < last; col++) {
                int offset = col - first;
                int temp = a[first][col];
                // first top = bottom first
                a[first][col] = a[last - offset][first];
                // bottom first to last bottom
                a[last - offset][first] = a[last][last - offset];
                //last bottom = top last
                a[last][last - offset] = a[col][last];
                a[col][last] = temp;
            }
        }
        return;


    }


}

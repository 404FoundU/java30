package DSA.Arrays;

//leetcode 48
//https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/lecture/23992650#overview
public class MatrixRotate {
    public static void main(String[] args) {
        MatrixRotate test = new MatrixRotate();
        int[][] intArr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        test.inPlaceRotate(intArr);
    }

    private void inPlaceRotate(int[][] a) {
        int n = a.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int col = first; col < last; col++) {
                int offset = col - first;
                int temp = a[first][col];
                // top left = bottom left
                a[first][col] = a[last - offset][first];
                // bottom right to bottom left
                a[last - offset][first] = a[last][last - offset];
                //bottom left = top right
                a[last][last - offset] = a[col][last];
                a[col][last] = temp;
            }
        }
        return;


    }


}

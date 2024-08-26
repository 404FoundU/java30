package DSA.Search;


import java.util.Arrays;

public class BinarySearch2D {
    public static void main(String[] args) {
        BinarySearch2D test = new BinarySearch2D();
        int[][] intArr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }; // 16

        test.testMethod(intArr, 16);

    }

    private int testMethod(int[][] a, int elem) {
        int[] colArr = new int[a.length];
        for (int i = 0; i < colArr.length; i++) {
            colArr[i] = a[i][0];
        }
        System.out.println(Arrays.toString(colArr));

        return 0;
    }


}

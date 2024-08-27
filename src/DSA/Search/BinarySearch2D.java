package DSA.Search;


import java.util.Arrays;

public class BinarySearch2D {
    public static void main(String[] args) {
        BinarySearch2D test = new BinarySearch2D();
        int[][] intArr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60},
                {63, 70, 74, 80}
        }; // 16

        int potentialRow = test.findPotentialRow(intArr, 34);
        System.out.println(potentialRow);
        // BinarySearch in row

    }

    private int findPotentialRow(int[][] a, int elem) {
        int length = a.length;
        int[] colArr = new int[length];
        for (int i = 0; i < length; i++) {
            colArr[i] = a[i][0];
        }
        System.out.println(Arrays.toString(colArr));

        int left = 0;
        int right = length - 1;
        int result = Integer.MIN_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (colArr[mid] == elem) {
                result = mid;
                break;
            } else if (colArr[mid] < elem) {
                left = mid + 1;
            } else if (colArr[mid] > elem) {
                right = mid - 1;
            }

        }
        System.out.println("left: " + left + ": right: " + right);
        if (left > length || right < 0) {
            return -1;
        }
        if (right <= left) {
            return left;
        }
        return -1;

    }


}

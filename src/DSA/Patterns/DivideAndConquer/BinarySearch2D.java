package DSA.Patterns.DivideAndConquer;


//https://www.youtube.com/watch?v=x-dYOtIudzc
public class BinarySearch2D {
    public static void main(String[] args) {
        BinarySearch2D test = new BinarySearch2D();
        int[][] intArr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60},
                {63, 70, 74, 80}
        }; // 16

        boolean present = test.bSearch(intArr, 34);
        System.out.println(present);
        // BinarySearch in row

    }

    private boolean bSearch(int[][] a, int elem) {

        int row = a.length;
        int col = a[0].length;
        int length = row * col;

        int l = 0;
        int r = length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int i = mid / col;
            int j = mid % col;
            if (a[i][j] == elem) {
                return true;
            }
            if (elem > a[i][j]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return false;
    }


}

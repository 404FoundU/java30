package DSA.Search;


public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch test = new BinarySearch();
        int[] intArr = new int[] {1, 3, 4, 5,6,9,14,20,30,100};

        test.testMethod(intArr, 9);

    }

    private int testMethod(int[] a, int elem) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (a[mid] == elem) {
                return mid;
            }
            if (elem > a[mid]) {
                left = mid+1;
            }
            if (elem < a[mid]) {
                right = mid-1;
            }

        }

        return -1;
    }



}

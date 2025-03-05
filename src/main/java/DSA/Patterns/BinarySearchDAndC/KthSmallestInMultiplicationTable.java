package DSA.Patterns.BinarySearchDAndC;

//https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
public class KthSmallestInMultiplicationTable {
    public static void main(String[] args) {
        // Test cases
        System.out.println(findKthNumber(3, 3, 5)); // Expected output: 3
        System.out.println(findKthNumber(2, 3, 6)); // Expected output: 6
    }

    public static int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (enough(mid, m, n, k)) {
                right = mid; // Try smaller values
            } else {
                left = mid + 1; // Increase the range
            }
        }

        return left; // The k-th smallest number
    }

    private static boolean enough(int num, int m, int n, int k) {
        int total = 0;

        for (int i = 1; i <= m; i++) {
            //number of elements in a single row of the multiplication table that are less than or equal to num
            int count;
            //For a given num, we want to count how many values in this row are ≤ num
            /*
            If num is smaller than the largest value in the row (i×n), only the first num/i values in the row are valid.
Otherwise, all n values in the row are valid.
             */
            if (num < n * i) {
                count = num / i; // Use num / i if it's less than n
            } else {
                count = n; // Use n if num  >= n * i
            }

            total += count;

            if (total >= k) {
                return true; // Stop early if we already have enough numbers
            }
        }

        return false; // Not enough numbers
    }

}


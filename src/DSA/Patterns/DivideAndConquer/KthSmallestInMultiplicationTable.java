package DSA.Patterns.DivideAndConquer;

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
        int count = 0;

        for (int i = 1; i <= m; i++) {
            int add;
            //For a given num, we want to count how many values in this row are ≤ num
            if (num < n * i) {
                add = num / i; // Use num / i if it's less than n
            } else {
                add = n; // Use n if num  >= n * i
            }

            count += add;

            if (count >= k) {
                return true; // Stop early if we already have enough numbers
            }
        }

        return false; // Not enough numbers
    }

}


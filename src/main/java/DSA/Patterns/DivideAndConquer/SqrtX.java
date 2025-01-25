package DSA.Patterns.DivideAndConquer;

/*
https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems

def binary_search(array) -> int:
    def condition(value) -> bool:
        pass

    left, right = min(search_space), max(search_space) # could be [0, n], [1, n] etc. Depends on problem
    while left < right:
        mid = left + (right - left) // 2
        if condition(mid):
            right = mid
        else:
            left = mid + 1
    return left
 */
public class SqrtX {
    public static void main(String[] args) {
        // Test cases
        int x1 = 4;   // Expected output: 2
        int x2 = 8;   // Expected output: 2
        int x3 = 0;   // Expected output: 0
        int x4 = 1;   // Expected output: 1
        int x5 = 2147395599; // Edge case, Expected output: 46339

        System.out.println("sqrt(" + x1 + ") = " + mySqrt(x1));
        System.out.println("sqrt(" + x2 + ") = " + mySqrt(x2));
        System.out.println("sqrt(" + x3 + ") = " + mySqrt(x3));
        System.out.println("sqrt(" + x4 + ") = " + mySqrt(x4));
        System.out.println("sqrt(" + x5 + ") = " + mySqrt(x5));
    }

    public static int mySqrt(int x) {
        int left = 0, right = x + 1; // Initialize search range

        while (left < right) {
            int mid = left + (right - left) / 2; // Avoid overflow

            if ((long) mid * mid > x) { // Use (long) to prevent overflow in multiplication
                right = mid; // Narrow the upper bound
            } else {
                left = mid + 1; // Narrow the lower bound
            }
        }

        return left - 1; // The correct square root is one less than `left`
    }
}


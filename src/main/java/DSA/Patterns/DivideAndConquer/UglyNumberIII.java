package DSA.Patterns.DivideAndConquer;

//https://www.youtube.com/watch?v=6koWSBGepxo
public class UglyNumberIII {
    public static void main(String[] args) {
        // Test cases
        System.out.println(nthUglyNumber(3, 2, 3, 5)); // Expected output: 4
        System.out.println(nthUglyNumber(4, 2, 3, 4)); // Expected output: 6
        System.out.println(nthUglyNumber(5, 2, 11, 13)); // Expected output: 10
        System.out.println(nthUglyNumber(1000000000, 2, 217983653, 336916467)); // Edge case
    }

    public static int nthUglyNumber(int n, int a, int b, int c) {
        // Calculate least common multiples (LCM)
        long ab = lcm(a, b);
        long ac = lcm(a, c);
        long bc = lcm(b, c);
        long abc = lcm(a, bc);

        // Binary search boundaries
        long left = 1, right = (long) n * Math.min(a, Math.min(b, c));

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (enough(mid, a, b, c, ab, ac, bc, abc, n)) {
                right = mid; // Narrow down the search
            } else {
                left = mid + 1; // Increase the range
            }
        }

        return (int) left; // The smallest number that satisfies the condition
    }

    private static boolean enough(long num, int a, int b, int c, long ab, long ac, long bc, long abc, int n) {
        // Inclusion-exclusion principle
        long total = (num / a) + (num / b) + (num / c)
                - (num / ab) - (num / ac) - (num / bc)
                + (num / abc);

        return total >= n; // Check if we have at least n ugly numbers
    }

    private static long lcm(long x, long y) {
        // Calculate least common multiple using gcd
        return (x * y) / gcd(x, y);
    }

    private static long gcd(long x, long y) {
        // Calculate greatest common divisor using Euclid's algorithm
        while (y != 0) {
            long temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}



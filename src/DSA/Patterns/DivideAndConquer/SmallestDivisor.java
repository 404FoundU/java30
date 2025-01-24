package DSA.Patterns.DivideAndConquer;

public class SmallestDivisor {
    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {1, 2, 5, 9};
        int threshold1 = 6; // Expected output: 5

        int[] nums2 = {44, 22, 33, 11, 1};
        int threshold2 = 5; // Expected output: 44

        int[] nums3 = {21212, 10101, 12121};
        int threshold3 = 1000000; // Expected output: 1

        System.out.println(smallestDivisor(nums1, threshold1));
        System.out.println(smallestDivisor(nums2, threshold2));
        System.out.println(smallestDivisor(nums3, threshold3));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt(); // Range of possible divisors

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isValid(nums, mid, threshold)) {
                right = mid; // Try smaller divisors
            } else {
                left = mid + 1; // Try larger divisors
            }
        }

        return left; // Smallest valid divisor
    }

    private static boolean isValid(int[] nums, int divisor, int threshold) {
        int sum = 0;

        for (int num : nums) {
            sum += (num + divisor - 1) / divisor; // Equivalent to Math.ceil(num / divisor)
            if (sum > threshold) {
                return false; // Early exit if sum exceeds threshold
            }
        }

        return sum <= threshold;
    }
}


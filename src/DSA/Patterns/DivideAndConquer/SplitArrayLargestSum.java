package DSA.Patterns.DivideAndConquer;

//https://leetcode.com/problems/split-array-largest-sum/description/
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {7, 2, 5, 10, 8};
        int m1 = 2; // Expected output: 18

        int[] nums2 = {1, 2, 3, 4, 5};
        int m2 = 2; // Expected output: 9

        int[] nums3 = {1, 4, 4};
        int m3 = 3; // Expected output: 4

        System.out.println("Minimum largest sum: " + splitArray(nums1, m1));
        System.out.println("Minimum largest sum: " + splitArray(nums2, m2));
        System.out.println("Minimum largest sum: " + splitArray(nums3, m3));
    }

    public static int splitArray(int[] nums, int m) {
        int left = getMax(nums); // Minimum possible largest sum
        int right = getSum(nums); // Maximum possible largest sum

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, m, mid)) {
                right = mid; // Try a smaller largest sum
            } else {
                left = mid + 1; // Increase the largest sum
            }
        }

        return left; // The minimized largest sum
    }

    // Helper method to check if the array can be split into `m` subarrays with max sum `capacity`
    private static boolean canSplit(int[] nums, int m, int capacity) {
        int currentSum = 0;
        int subarrays = 1;

        for (int num : nums) {
            if (currentSum + num > capacity) {
                subarrays++;
                currentSum = num; // Start a new subarray
                if (subarrays > m) {
                    return false; // More subarrays than allowed
                }
            } else {
                currentSum += num;
            }
        }

        return true;
    }

    // Helper method to get the maximum value in the array
    private static int getMax(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    // Helper method to get the sum of all values in the array
    private static int getSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}


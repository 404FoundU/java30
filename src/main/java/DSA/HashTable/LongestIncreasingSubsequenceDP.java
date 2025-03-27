package DSA.HashTable;

import java.util.Arrays;

public class LongestIncreasingSubsequenceDP {

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Every number is at least a subsequence of length 1

        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18}; // Expected: 4
        int[] nums2 = {0, 1, 0, 3, 2, 3};           // Expected: 4
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};        // Expected: 1

        System.out.println("LIS length (nums1): " + lengthOfLIS(nums1));
        System.out.println("LIS length (nums2): " + lengthOfLIS(nums2));
        System.out.println("LIS length (nums3): " + lengthOfLIS(nums3));
    }
}


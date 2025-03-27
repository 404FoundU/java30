package DSA.HashTable;

import java.util.Arrays;

//https://www.youtube.com/watch?v=cjWnW0hdF1Y
public class LongestIncreasingSubsequenceDP {

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int maxLength = 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Every number is at least a subsequence of length 1
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

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
        int[] nums4 = {1, 2, 4, 3};        // Expected: 1

        System.out.println("LIS length (nums1): " + lengthOfLIS(nums1));
        System.out.println("LIS length (nums2): " + lengthOfLIS(nums2));
        System.out.println("LIS length (nums3): " + lengthOfLIS(nums3));
        System.out.println("LIS length (nums4): " + lengthOfLIS(nums4));
    }
}

/*
LIS[3] = 1 // last element
LIS[2] = Max ( 1 , 1 + LIS[3] )
LIS[1] = Max (1 , 1 + LIS[2] , 1 + LIS[3]) = 2
LIST[0] = Max (1 , 1 + LIS[1], 1 + LIS[2] , 1 + LIS[3] ) = 3
 */


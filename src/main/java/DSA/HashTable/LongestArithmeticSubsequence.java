package DSA.HashTable;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=_xIkHvSZpDE
//https://leetcode.com/problems/longest-arithmetic-subsequence/description/
public class LongestArithmeticSubsequence {


    public static int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        Map<Integer, Integer>[] dp = new HashMap[n];
        Integer[] intArray = new Integer[]{};
        int maxLength = 2;
        for (int k = 0; k < n; k++) {
            dp[k] = new HashMap<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // diff of all the elements wrt i
                int diff = nums[j] - nums[i];

                int existingLength;

                Map<Integer, Integer> diffMap = dp[j];

                //does the same difference exist in the previous map. Increment it by 1
                if (diffMap.containsKey(diff)) {
                    existingLength = diffMap.get(diff);
                } else {
                    existingLength = 1;
                }

                int calculatedLength = existingLength + 1;
                // for 3,6 we do not have any elements prior to it so
                // for index 1 we have (diff, calLength) = (-3, 2 )
                // UPdate current map with the diff count from previous map
                dp[i].put(diff, calculatedLength);
                maxLength = Math.max(calculatedLength, maxLength);

            }
        }
        return maxLength;
    }

    public static int longestArithSeqLengthBF(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        int maxLength = 2;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = nums[j] - nums[i];
                int currLength = 2;

                int prev = nums[j];
                for (int k = j + 1; k < n; k++) {

                    if (diff == nums[k] - prev) {
                        currLength++;
                        prev = nums[k];
                    }
                }
                maxLength = Math.max(currLength, maxLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 6, 9, 12};
        int[] nums2 = {9, 4, 7, 2, 10};
        int[] nums3 = {20, 1, 15, 3, 10, 5, 8};

        System.out.println("Example 1: " + longestArithSeqLength(nums1)); // 4
//        System.out.println("Example 2: " + longestArithSeqLength(nums2)); // 3
//        System.out.println("Example 3: " + longestArithSeqLength(nums3)); // 4
    }
}

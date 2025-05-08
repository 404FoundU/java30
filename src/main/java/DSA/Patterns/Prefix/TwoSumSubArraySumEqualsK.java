package DSA.Patterns.Prefix;


import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=AmlVSNBHzJg
//https://youtu.be/EFzYA9H0MfQ?si=Sil5VR2KCbEuFOsL
//https://leetcode.com/problems/subarray-sum-equals-k/description/
/*
Say you are given an array e.g. [a0, a1, a2, a3, a4, a5, a6... an] .

[a0,  a1,  a2,    a3,   a4,   a5,  a6, ... an]
	        ^	                   ^
             sumI	                sumJ


sumI = sum of numbers till a2 (a0 + a1 + a2)
sumJ = sum of numbers till a5 (a0 + a1 + a2 + a3 + a4 + a5)


Now lets say the difference between sumJ and sumI is equal to k.
What that means is, the sum of numbers between a2 and a5 is equal to k ( a3 + a4 + a5 = k ),
 which means we found a subarray whose sum is equal to k.

We can write a3 + a4 + a5 = k as sumJ - sumI = k and sumJ - sumI = k can be written
as sumJ - k = sumI


The expression sumJ - k = sumI, means have we already seen a sum which is equal to sum at current index j minus k.
If yes, it means we found a subarray whose sum is equal to k.
 */
public class TwoSumSubArraySumEqualsK {


    public static void main(String[] args) {
        TwoSumSubArraySumEqualsK test = new TwoSumSubArraySumEqualsK();
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
//        System.out.println(subarraySum(nums1, k1)); // Output: 2

        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println(subarraySum(nums2, k2)); // Output: 2

        int[] nums3 = {3, 4, 7, 2, -3, 1, 4, 2};
        int k3 = 7;
//        System.out.println(subarraySum(nums3, k3)); // Output: 4

    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumAndCount = new HashMap<>();
        prefixSumAndCount.put(0, 1); // base case: one way to get sum = 0
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            int target = sum - k;
            if (prefixSumAndCount.containsKey(target)) {
                int existingCountForTargetSum = prefixSumAndCount.get(target);
                count += existingCountForTargetSum;
            }
            if (prefixSumAndCount.containsKey(sum)) {
                int existingCount = prefixSumAndCount.get(sum);
                prefixSumAndCount.put(sum, existingCount + 1);
            } else {
                prefixSumAndCount.put(sum, 1);
            }
        }
        return count;
    }

    public static int subarraySumBF(int[] nums, int k) {
        Map<Integer, Integer> prefixSumAndCount = new HashMap<>();
        prefixSumAndCount.put(0, 1);
        int sum = 0;
        int start = 0;
        while (start < nums.length) {
            for (int i = start; i < nums.length; i++) {
                sum += nums[i];
                if (prefixSumAndCount.containsKey(sum)) {
                    int existingCount = prefixSumAndCount.get(sum);
                    prefixSumAndCount.put(sum, existingCount + 1);
                } else {
                    prefixSumAndCount.put(sum, 1);
                }
            }
            start++;
            sum = 0;
        }
        return prefixSumAndCount.get(k);

    }


    public static int subarraySumUsingPrefixArray(int[] nums, int k) {
        int n = nums.length;

        // Build cumulative prefix sum array
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int count = 0;

        // Check all pairs (i, j)
        for (int start = 0; start < n; start++) {
            for (int end = start + 1; end <= n; end++) {
                if (prefixSum[end] - prefixSum[start] == k) {
                    count++;
                }
            }
        }

        return count;
    }

}

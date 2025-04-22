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

We can write a3 + a4 + a5 = k as sumJ - sumI = k and sumJ - sumI = k can be written as sumJ - k = sumI

The expression sumJ - k = sumI, means have we already seen a sum which is equal to sum at current index j minus k. If yes, it means we found a subarray whose sum is equal to k.
 */
public class TwoSumSubArraySumEqualsK {


    public static void main(String[] args) {
        TwoSumSubArraySumEqualsK test = new TwoSumSubArraySumEqualsK();

        int[] ints = {1, 1, 1};
        int target = 2;
        System.out.println(subarraySum(ints, target));

    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1); // base case: one way to get sum = 0

        for (int num : nums) {
            sum += num;

            //sumI = sumJ-k
            int required = sum - k;
            // have we seen the required sum before
            if (prefixSumFreq.containsKey(required)) {
                count += prefixSumFreq.get(required);
            }

            if (prefixSumFreq.containsKey(sum)) {
                int freq = prefixSumFreq.get(sum);
                prefixSumFreq.put(sum, freq + 1);
            } else {
                prefixSumFreq.put(sum, 1);
            }
        }

        return count;
    }

    public static int subarraySumBF(int[] nums, int k) {
        int count = 0;
        int n = nums.length;

        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += nums[end];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}

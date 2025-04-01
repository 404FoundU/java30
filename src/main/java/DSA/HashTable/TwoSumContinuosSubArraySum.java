package DSA.HashTable;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://youtu.be/EFzYA9H0MfQ?si=Sil5VR2KCbEuFOsL
//https://leetcode.com/problems/subarray-sum-equals-k/description/
public class TwoSumContinuosSubArraySum {


    public static void main(String[] args) {
        TwoSumContinuosSubArraySum test = new TwoSumContinuosSubArraySum();

        int[] ints = {1, 2, 3, 4, 5};
        int target = 9;
        System.out.println(Arrays.toString(test.testMethod(ints, target)));

    }

    // sliding window sol

    //prefix sum or cumulative sum
    //https://www.youtube.com/watch?v=AmlVSNBHzJg&t=313s
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1); // base case: one way to get sum = 0

        for (int num : nums) {
            sum += num;

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


    /*



Say you are given an array e.g. [a0, a1, a2, a3, a4, a5, a6... an] .

[a0,  a1,  a2,    a3,   a4,   a5,  a6, ... an]
	        ^	                   ^
             sumI	                sumJ


sumI = sum of numbers till a2 (a0 + a1 + a2)
sumJ = sum of numbers till a5 (a0 + a1 + a2 + a3 + a4 + a5)


Now lets say the difference between sumJ and sumI is equal to k.
What that means is, the sum of numbers between a2 and a5 is equal to k ( a3 + a4 + a5 = k ), which means we found a subarray whose sum is equal to k.

We can write a3 + a4 + a5 = k as sumJ - sumI = k and sumJ - sumI = k can be written as sumJ - k = sumI

The expression sumJ - k = sumI, means have we already seen a sum which is equal to sum at current index j minus k. If yes, it means we found a subarray whose sum is equal to k.

And we keep track of how many times we see a particular sum using a HashMap.
     */

    private int[] testMethod(int[] num, int target) {
        HashTable<Integer, Integer> cumulativeSumIndex = new HashTable<>();
        int currentSum = 0;
        cumulativeSumIndex.put(currentSum, -1);
        for (int i = 0; i < num.length; i++) {
            currentSum = currentSum + num[i];
            int compliment = currentSum - target;
            if (cumulativeSumIndex.get(compliment) != null) {
                return new int[]{cumulativeSumIndex.get(compliment) + 1, i};
            } else {
                cumulativeSumIndex.put(currentSum, i);
            }
        }
        return new int[]{};


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

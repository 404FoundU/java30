package DSA.HashTable;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=AmlVSNBHzJg
//https://leetcode.com/problems/subarray-sum-equals-k/description/
public class TwoSumContinuosSubArraySum {


    public static void main(String[] args) {
        TwoSumContinuosSubArraySum test = new TwoSumContinuosSubArraySum();

        int[] ints = {1, 2, 3, 4, 5};
        int target = 9;
        System.out.println(Arrays.toString(test.testMethod(ints, target)));

    }

    public static int subarraySumSW(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > k && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                count++;
            }
        }

        return count;
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1); // base case: one way to get sum = 0

        for (int num : nums) {
            sum += num;

            int required = sum - k;
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

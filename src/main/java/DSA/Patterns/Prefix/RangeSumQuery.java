package DSA.Patterns.Prefix;

/*
https://leetcode.com/problems/range-sum-query-immutable/
 */
public class RangeSumQuery {
    private int[] prefixSum;

    // Constructor to build prefix sum
    public RangeSumQuery(int[] nums) {
        int n = nums.length;
        prefixSum = new int[n + 1]; // extra 0 at beginning

        prefixSum[0] = 0;

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    // O(1) query
    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQuery obj = new RangeSumQuery(nums);

        System.out.println(obj.sumRange(0, 2)); // Output: 1
        System.out.println(obj.sumRange(2, 5)); // Output: -1
        System.out.println(obj.sumRange(0, 5)); // Output: -3
    }
}

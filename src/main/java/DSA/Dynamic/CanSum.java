package DSA.Dynamic;

import java.util.HashMap;
import java.util.Map;

// decision problem
public class CanSum {

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{5, 3, 4, 7}));
    }

    private static boolean canSum(int targetSum, int[] nums) {

        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int newTargetSum = targetSum - nums[i];
            if (canSum(newTargetSum, nums)) {
                return true;
            }
        }
        return false;
    }

    private static final Map<Integer, Boolean> memo = new HashMap<>();

    private static boolean canSumMemo(int targetSum, int[] nums) {

        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int newTargetSum = targetSum - nums[i];
            if (canSum(newTargetSum, nums)) {
                memo.put(newTargetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }

    /*
    complexity
    if m is the target sum
    depth will be -1(worst case) on each level. So depth = m
    width is the number of elements in nums array n
    so, n^m

space:
depth = n
recursion does not create new arrays. O(1)
total = O(n)
     */
}

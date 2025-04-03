package DSA.Patterns.TwoPointer;


import java.util.Arrays;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class TwoSumII {


    public static void main(String[] args) {
        TwoSumII test = new TwoSumII();

        //input array is sorted
        int[] ints = {2, 7, 11, 15};
        int sum = 18;
        System.out.println(Arrays.toString(test.testMethod(ints, sum)));

    }

    private int[] testMethod(int[] num, int target) {
        int left = 0;
        int right = num.length - 1;
        while (left < right) {
            int sum = num[left] + num[right];
            if (sum == target) {
                return new int[]{left, right};
            }
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{};
    }
}
// 2 pointer

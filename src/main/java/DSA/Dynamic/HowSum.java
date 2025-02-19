package DSA.Dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// return null if you cant make targetSum

//combinatoric problem
public class HowSum {

    public static void main(String[] args) {
        System.out.println(howSum(7, new int[]{5, 3, 4, 7}));
    }

    private static List<Integer> howSum(int targetSum, int[] nums) {
        if (targetSum == 0) {
            return new ArrayList<>();
        }

        if (targetSum < 0) {
            return null;
        }
        for (int num : nums) {
            int newTargetSum = targetSum - num;
            List<Integer> integerList = howSum(newTargetSum, nums);
            if (integerList != null) {
                List<Integer> sumList = new ArrayList<>(integerList);
                sumList.add(num);
                return sumList;
            }
        }
        return null;
    }

    private static final Map<Integer, List<Integer>> memo = new HashMap<>();

    private static List<Integer> howSumMemo(int targetSum, int[] nums) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return new ArrayList<>();
        }

        if (targetSum < 0) {
            return null;
        }
        for (int num : nums) {
            int newTargetSum = targetSum - num;
            List<Integer> integerList = howSumMemo(newTargetSum, nums);
            if (integerList != null) {
                List<Integer> sumList = new ArrayList<>(integerList);
                sumList.add(num);
                memo.put(newTargetSum, sumList);
                return sumList;
            }
        }
        memo.put(targetSum, null);
        return null;
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

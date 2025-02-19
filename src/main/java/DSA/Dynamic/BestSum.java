package DSA.Dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// return null if you cant make targetSum

// optimization problem
public class BestSum {

    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[]{5, 3, 4, 7}));
    }

    private static List<Integer> bestSum(int targetSum, int[] nums) {
        if (targetSum == 0) {
            return new ArrayList<>();
        }

        if (targetSum < 0) {
            return null;
        }
        List<Integer> shortestCombination = null;
        for (int num : nums) {
            int newTargetSum = targetSum - num;
            List<Integer> integerList = bestSum(newTargetSum, nums);
            if (integerList != null) {
                List<Integer> combination = new ArrayList<>(integerList);
                combination.add(num);
                if (shortestCombination == null || shortestCombination.size() > combination.size()) {
                    shortestCombination = new ArrayList<>(combination);
                }
            }
        }
        return shortestCombination;
    }

    private static final Map<Integer, List<Integer>> memo = new HashMap<>();

    private static List<Integer> bestSumMemo(int targetSum, int[] nums) {
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        if (targetSum < 0) {
            return null;
        }

        if (memo.containsKey(targetSum)) {
            memo.get(targetSum);
        }
        List<Integer> shortestCombination = null;
        for (int num : nums) {
            int newTargetSum = targetSum - num;
            List<Integer> integerList = bestSum(newTargetSum, nums);
            if (integerList != null) {
                List<Integer> combination = new ArrayList<>(integerList);
                combination.add(num);
                if (shortestCombination == null || shortestCombination.size() > combination.size()) {
                    shortestCombination = new ArrayList<>(combination);
                }
            }
        }
        memo.put(targetSum, shortestCombination);
        return shortestCombination;
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

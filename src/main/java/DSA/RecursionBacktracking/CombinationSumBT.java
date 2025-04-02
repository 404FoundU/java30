package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumBT {

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> sol = new ArrayList<>();
        int n = candidates.length;

        backtrack(0, 0, candidates, target, sol, n);

        return res;
    }

    public static void backtrack(int start, int curSum, int[] nums, int target,
                                 List<Integer> sol, int n) {

        if (curSum == target) {
            res.add(new ArrayList<>(sol));
            return;
        }

        if (curSum > target || start == n) {
            return;
        }

        // Skip current index
        backtrack(start + 1, curSum, nums, target, sol, n);

        // Include current number (can reuse)
        sol.add(nums[start]);
        backtrack(start, curSum + nums[start], nums, target, sol, n);
        sol.remove(sol.size() - 1); // backtrack
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println("Combinations: " + result);
    }
}






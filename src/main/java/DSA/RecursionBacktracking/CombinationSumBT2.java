package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumBT2 {
    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private static void backtrack(int[] nums, int target, List<Integer> current, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // found valid combination
            return;
        }

        if (target < 0) return; // prune path

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);                    // choose
            backtrack(nums, target - nums[i], current, i); // not i + 1 because we can reuse same
            current.remove(current.size() - 1);            // backtrack
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> output = combinationSum(candidates, target);
        System.out.println("Combinations: " + output);
    }
}
/*
Start with 7
├── use 2 → 5
│   ├── use 2 → 3
│   │   ├── use 2 → 1
│   │   │   ├── use 2 → -1 ✖ backtrack
│   │   ├── use 3 → 0 ✅ [2,2,3]
│   ├── use 3 → 2
│   ├── use 6 → -1 ✖
├── use 3 → 4
├── use 6 → 1
├── use 7 → 0 ✅ [7]
[]
 */




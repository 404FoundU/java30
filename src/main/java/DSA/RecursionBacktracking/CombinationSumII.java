package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result.clear(); // reset global list
        Arrays.sort(candidates); // sorting is required to skip duplicates
        backtrack(candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private static void backtrack(int[] nums, int target, List<Integer> current, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates at the same level
            if (i > start && nums[i] == nums[i - 1]) continue;

            //If the current number is already greater than the remaining target,
            //Then any number after it (which will be even bigger) will also exceed the target.
            if (nums[i] > target) break; // pruning since array is sorted

            current.add(nums[i]);                      // choose
            backtrack(nums, target - nums[i], current, i + 1); // i+1 → no reuse
            current.remove(current.size() - 1);        // backtrack
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> combinations = combinationSum2(candidates, target);
        System.out.println("Combinations: " + combinations);
    }
}

/*
Start with target = 8
├── 1 → target = 7
│            ├── 1 → 6
│            │      ├── 2 → 4
│            │      │        ├── 5 → -1 ✖ (continue)
│            │      │        ├── 6 → -2 ✖
│            │      │        ├── 7 → -3 ✖
│            │      │        ├── 10 → -6 ✖  ← PRUNED due to break
│            ├── 2 → 5
│            │   ├── 5 → 0 ✅
│            │   ├── 6 → -1 ✖
│            │   └── 7 → -2 ✖
│            │   └── 10 → -5 ✖ ← PRUNED
...
├── 7 → 1
│   └── 10 → -9 ✖ ← PRUNED


 */

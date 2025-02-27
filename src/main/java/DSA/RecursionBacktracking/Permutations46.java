package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        // Base Case: If all numbers are used, store the permutation
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        // Try each number that hasn't been used yet
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // Skip already used numbers

            // Pick the number
            used[i] = true;
            tempList.add(nums[i]);

            // Recur to generate remaining permutations
            backtrack(result, tempList, nums, used);

            // Undo choice (Backtrack)
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = permute(nums);
        System.out.println(permutations);
    }
}

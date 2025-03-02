package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {

    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private static void backtrack(List<Integer> tempList, int[] nums, boolean[] used) {
        // If reached goal
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
// no need of used
        // Loop through all choices (NB_CHOICES)
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue; // skip already used numbers
            }
            //include the number
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(tempList, nums, used);
            //dont include the number
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

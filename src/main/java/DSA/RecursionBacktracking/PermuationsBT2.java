package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

public class PermuationsBT2 {

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> permutations(List<Integer> nums) {
        List<Integer> perm = new ArrayList<>();

        backtrack(nums, perm);

        return result;
    }

    private static void backtrack(List<Integer> nums, List<Integer> perm) {
        if (nums.size() == perm.size()) {
            result.add(new ArrayList<>(perm));  // Create a new list for the solution
            return;
        }

        for (int num : nums) {
            if (!perm.contains(num)) {
                perm.add(num);
                backtrack(nums, perm);
                perm.remove(perm.size() - 1);  // Remove the last element (backtrack)
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3);
        List<List<Integer>> result = permutations(nums);
        System.out.println(result);
        //[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    }
}





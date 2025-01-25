package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=UP3dOYJa05s
public class CombinationSumBT {

    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> sol = new ArrayList<>();
    static List<Integer> nums = new ArrayList<>();
    static int targetSum = 0;

    public static List<List<Integer>> subsets(List<Integer> arr, int target) {
        targetSum = target;
        nums = arr;
        for (int i = 0; i < nums.size(); i++) {
            backtrack(i, 0);
        }
        return result;
    }

    private static void backtrack(int start, int sum) {
        if (sum == targetSum) {
            result.add(new ArrayList<>(sol));
            return;
        }
        if (nums.size() == start || sum > targetSum) { // index goes out of bound
            return;
        }
        backtrack(start + 1, sum); // new number
        sol.add(nums.get(start));
        backtrack(start, sum + nums.get(start)); // same number
        sol.remove(sol.size() - 1);

    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(2, 3, 5);  // Example input
        List<List<Integer>> result = subsets(nums, 8);
        System.out.println(result);
    }
}





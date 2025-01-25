package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=UP3dOYJa05s
public class SubsetsBT {

    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> sol = new ArrayList<>();
    static List<Integer> nums = new ArrayList<>();

    public static List<List<Integer>> subsets(List<Integer> arr) {
        nums.addAll(arr);
        backtrack(0);
        return result;
    }

    private static void backtrack(int start) {
        if (nums.size() == start) { // index goes out of bound
            result.add(new ArrayList<>(sol));
            return;
        }
        //Dont pick nums[i]
        backtrack(start + 1);
        //pick nums[i]
        sol.add(nums.get(start));
        backtrack(start + 1);
        sol.remove(sol.size() - 1);
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3);  // Example input
        List<List<Integer>> result = subsets(nums);
        System.out.println(result);
    }
}





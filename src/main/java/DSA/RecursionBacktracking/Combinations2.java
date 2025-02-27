package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combinations/description/
public class Combinations2 {

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {

        backtrack(new ArrayList<>(), n, k, 1);
        return result;
    }

    private static void backtrack(List<Integer> tempList, int n, int k, int start) {
        // Base case: If k elements are selected, add to result
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        // Loop from 'start' to 'n' to ensure uniqueness
        for (int i = start; i <= n; i++) {
            tempList.add(i); // Pick the number
            backtrack(tempList, n, k, i + 1); // Move to next choice
            tempList.remove(tempList.size() - 1); // Undo choice (Backtrack)
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> combinations = combine(n, k);
        System.out.println(combinations);
    }
}


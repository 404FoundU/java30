package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combinations/description/
public class Combinations77 {

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        backtrack(new ArrayList<>(), n, k, 1);
        return result;
    }
    private static void backtrack(List<Integer> tempList, int n, int k, int start) {
        // If reached goal
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        // Loop through all choices (NB_CHOICES)
        for (int i = start; i <= n; i++) {
            //include the number
            tempList.add(i);
            backtrack(tempList, n, k, i);
            //dont include the number
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> combinations = combine(n, k);
        System.out.println(combinations);
    }
}


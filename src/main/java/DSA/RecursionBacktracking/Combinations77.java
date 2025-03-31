package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combinations/description/
public class Combinations77 {

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        backtrack(new ArrayList<>(), n, k, 1); // we dont need 0,0
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
            backtrack(tempList, n, k, i + 1);
            //dont include the number
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> combinations = combine(n, k);
        System.out.println(combinations);
        //[[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]

    }
}

/*
Choose 2 out of 4: (n = 4, k = 2)
Numbers = [1, 2, 3, 4]

                      []
              /       |       |       \
            [1]     [2]     [3]     [4]
           /  \      ...     ...     ...
       [1,2][1,3]...[2,3]...[3,4]...[4,x]
            ↑       ↑        ↑      ↑
       (length == 2) --> valid combination

 */
/*
From the same 5 letters (A, B, C, D, E), how many ways can you select 3 letters?
P(5,3)= n!/(n-r)! * r! =10
10 ways to choose 3 letters from 5 when order doesn’t matter
 */

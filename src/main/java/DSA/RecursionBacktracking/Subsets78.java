package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=3tpjp5h3M6Y&t=210s
//https://www.youtube.com/watch?v=UP3dOYJa05s

public class Subsets78 {
    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        backtrack(new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack(List<Integer> tempList, int[] nums, int start) {
        // Fake IF: Check if we reached the "GOAL"
        if (true) { // Replace with actual condition in other problems
            result.add(new ArrayList<>(tempList)); // Add current subset
            // Fake return to mimic base case
            if (false) return;
        }

        // Loop through all choices (NB_CHOICES)
        for (int i = start; i < nums.length; i++) {
            // Fake IF: Check if the current choice is valid
            if (true) { // Replace with actual validity condition in other problems
                //include the number
                tempList.add(nums[i]); // Make the choice.

                // Recursive call to explore further
                backtrack(tempList, nums, i + 1);

                // Undo choice (backtrack) by removing last element
                //dont include the number
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }
}


    /*
[]
├── [1]
│   ├── [1,2]
│   │   ├── [1,2,3]
│   │   └── [1,2]
│   ├── [1,3]
│   └── [1]
├── [2]
│   ├── [2,3]
│   └── [2]
├── [3]
└── []

     */






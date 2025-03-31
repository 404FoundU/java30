package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=3tpjp5h3M6Y&t=210s
//https://www.youtube.com/watch?v=UP3dOYJa05s
//https://www.youtube.com/watch?v=Nabbpl7y4Lo&t=195s
//https://leetcode.com/problems/subsets/description/
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
                // Move to the next element (adjust start index for the next recursion)

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





/*
Steps of Include/Exclude:
Base Case:

At the beginning of each call to backtrack, we add the current combination (which starts empty) to the results. This ensures that we include the empty combination as well.
The result list is modified in this step, capturing the current state of the combination, whether it's empty or contains some elements.
Loop Through Elements:

A for loop iterates through the list starting from the start index.
For each element in the list (let's call the current element arr[i]), we have two choices:
Include arr[i]: This is done by adding arr[i] to the combination list.
Exclude arr[i]: This occurs naturally because, after exploring the inclusion, we will backtrack and remove the last added element.
Recursive Call:

After including an element (e.g., arr[i]), we make a recursive call to backtrack, but we increment the start index to i + 1. This means the next recursive call will only consider elements that come after arr[i], ensuring that we don’t include the same element again in this combination.
This recursive structure allows the algorithm to explore all paths: it first explores paths including the current element, then it backtracks and explores paths excluding it.
Backtrack (Undo the Choice):

After returning from the recursive call (i.e., after exploring all combinations that include arr[i]), we remove the last element from combination. This step effectively "undoes" the inclusion, allowing us to explore combinations that do not include arr[i].
The next iteration of the loop will then consider the next element in the list, continuing this process.
Example Walkthrough
For example, with the input {'a', 'b', 'c'}:

Start with an empty combination: [].
Include a: ['a'].
    Next, include b: ['a', 'b'].
        Include c: ['a', 'b', 'c'] → Add to result.
        Backtrack to ['a', 'b'] and exclude c → Add to result.
    Backtrack to ['a'] and exclude b.
        Include c: ['a', 'c'] → Add to result.
    Backtrack to [] and exclude a.
        Include b: ['b'].
            Include c: ['b', 'c'] → Add to result.
    Backtrack to [] and exclude b.
        Include c: ['c'] → Add to result.
This exploration of choices leads to the generation of all combinations, including the empty set.
 */




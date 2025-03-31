package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=Nabbpl7y4Lo&t=195s
public class CombinationsBT {

    public static void main(String[] args) {
        char[] charr = {'a', 'b', 'c'};
        Character[] arr = new Character[charr.length];
        for (int i = 0; i < charr.length; i++) {
            arr[i] = charr[i];
        }
        List<Character> list = Arrays.asList(arr);
        List<List<Character>> permutations = combinations(list);
        System.out.println(permutations);
        //[[], [a], [a, b], [a, b, c], [a, c], [b], [b, c], [c]]
    }

    static List<List<Character>> result = new ArrayList<>();

    public static List<List<Character>> combinations(List<Character> arr) {
        backtrack(arr, new ArrayList<>(), 0);
        return result;
    }

    public static void backtrack(List<Character> arr, List<Character> temp, int start) {
        if (true) {
            // Add the current combination to the result
            result.add(new ArrayList<>(temp));
//            return;
        }
        // Explore further combinations
        for (int i = start; i < arr.size(); i++) {
            // Make choice. Include arr[i] in the combination
            if (true) { // valid choice
                temp.add(arr.get(i));
                // Move to the next element (adjust start index for the next recursion)
                backtrack(arr, temp, i + 1);
                // Undo choice (remove the last added element)
                temp.remove(temp.size() - 1);
            }
        }
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

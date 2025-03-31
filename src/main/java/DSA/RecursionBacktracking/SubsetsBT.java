package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=Nabbpl7y4Lo&t=195s
//https://leetcode.com/problems/subsets/description/
public class SubsetsBT {

    public static void main(String[] args) {
        char[] charr = {'a', 'b', 'c'};
        Character[] arr = new Character[charr.length];
        for (int i = 0; i < charr.length; i++) {
            arr[i] = charr[i];
        }
        List<Character> list = Arrays.asList(arr);
        List<List<Character>> allCombinations = subsets(list); // subsets . 2^n
        System.out.println(allCombinations);
        //[[], [a], [a, b], [a, b, c], [a, c], [b], [b, c], [c]]
    }

    static List<List<Character>> result = new ArrayList<>();

    public static List<List<Character>> subsets(List<Character> arr) {
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


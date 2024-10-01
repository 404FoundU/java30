package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=Nabbpl7y4Lo&t=195s
public class PermutationsBT {

    public static void main(String[] args) {
        char[] charr = {'a', 'b', 'c'};
        Character[] arr = new Character[charr.length];
        for (int i = 0; i < charr.length; i++) {
            arr[i] = charr[i];
        }
        List<Character> list = Arrays.asList(arr);
        List<List<Character>> permutations = permutations(list);
        System.out.println(permutations);
    }

    static List<List<Character>> result = new ArrayList<>();

    public static List<List<Character>> permutations(List<Character> arr) {
        backtrack(arr, new ArrayList<>(), new boolean[arr.size()]);
        return result;
    }

    public static void backtrack(List<Character> arr, List<Character> perm, boolean[] visited) {
        if (perm.size() == arr.size()) { // goal reached
            result.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < arr.size(); i++) { //choices
            // did we already use arr[i]. use a hashmap or boolean array used[i]
            if (!visited[i]) {
                //make choice
                visited[i] = true;
                perm.add(arr.get(i));
                //backtrack
                backtrack(arr, perm, visited);
                //undo choice
                visited[i] = false;
                perm.remove(arr.get(i));
            }
        }
    }
}

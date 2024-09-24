package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=mEBEw_xScsE
public class Permutations {

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c'};
        List<List<Character>> permutations = permutations(arr);
        System.out.println(permutations);
    }

    public static List<List<Character>> permutations(char[] arr) {
        if (arr.length == 0) {
            List<List<Character>> emptyPermutation = new ArrayList<>();

            emptyPermutation.add(new ArrayList<>());
            System.out.println(emptyPermutation);

            return emptyPermutation;
        }

        char firstEl = arr[0];
        char[] restEl = new char[arr.length - 1];
        System.arraycopy(arr, 1, restEl, 0, arr.length - 1);

        List<List<Character>> permWithoutFirst = permutations(restEl);
        List<List<Character>> allPermutations = new ArrayList<>();

        for (List<Character> singlePerm : permWithoutFirst) {
            for (int i = 0; i <= singlePerm.size(); i++) {
                List<Character> singleCombWithFirst = new ArrayList<>(singlePerm);

                singleCombWithFirst.add(i, firstEl);
                System.out.println("singleCombWithFirst:" + singleCombWithFirst);

                allPermutations.add(singleCombWithFirst);
                System.out.println("combWithFirst:" + allPermutations);
            }

        }

        return allPermutations;
    }
}

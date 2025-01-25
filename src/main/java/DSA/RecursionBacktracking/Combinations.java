package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c'};
        List<Character> list = Arrays.asList('a', 'b', 'c');
        List<List<Character>> combinations = combination(arr);
        System.out.println(combinations);
    }

    public static List<List<Character>> combination(char[] arr) {
        if (arr.length == 0) {
            List<List<Character>> emptyCombination = new ArrayList<>();

            emptyCombination.add(new ArrayList<>());
            System.out.println(emptyCombination);

            return emptyCombination;
        }

        char firstEl = arr[0];
        char[] restEl = new char[arr.length - 1];
        System.arraycopy(arr, 1, restEl, 0, arr.length - 1);

        List<List<Character>> combWithoutFirst = combination(restEl);
        List<List<Character>> combWithFirst = new ArrayList<>();

        for (List<Character> singleComb : combWithoutFirst) {
            List<Character> singleCombWithFirst = new ArrayList<>(singleComb);
            singleCombWithFirst.add(firstEl);
            System.out.println("singleCombWithFirst:" + singleCombWithFirst);

            combWithFirst.add(singleCombWithFirst);
            System.out.println("combWithFirst:" + combWithFirst);

        }

        List<List<Character>> result = new ArrayList<>(combWithFirst);
        result.addAll(combWithoutFirst);

        return result;
    }
}

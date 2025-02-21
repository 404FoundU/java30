package DSA.Dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// combinatorics problem
// return 2d array of elements
public class AllConstructString {

    public static void main(String[] args) {
        System.out.println(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef"}));
    }

    private static List<List<String>> allConstruct(String target, String[] words) {
        if (target.isEmpty()) {
            return new ArrayList<>(Collections.singletonList(new ArrayList<>()));
        }

        List<List<String>> result = new ArrayList<>();

        for (String word : words) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstruct(suffix, words);

                for (List<String> way : suffixWays) { // add word to each level
                    List<String> newCombination = new ArrayList<>(way);
                    newCombination.add(0, word); // Correctly add word at the beginning
                    result.add(newCombination);
                }
            }
        }
        return result;
    }

    private static final Map<String, List<List<String>>> memo = new HashMap<>();

    private static List<List<String>> allConstructMemo(String target, String[] words) {
        if (target.isEmpty()) {
            return new ArrayList<>(Collections.singletonList(new ArrayList<>()));
        }
        if (memo.containsKey(target)) {
            memo.get(target);
        }
        List<List<String>> result = new ArrayList<>();
        for (String word : words) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstructMemo(suffix, words);
                for (List<String> way : suffixWays) { // add word to each level
                    List<String> newCombination = new ArrayList<>(way);
                    newCombination.add(0, word); // Correctly add word at the beginning
                    result.add(newCombination);
                }
            }
        }
        memo.put(target, result);
        return result;
    }
}

package DSA.Dynamic;

import java.util.HashMap;
import java.util.Map;


// combinatorics problem
public class CountConstructString {

    public static void main(String[] args) {
        System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
    }

    private static int countConstruct(String target, String[] words) {
        if (target.isEmpty()) {
            return 1;
        }
        int totalCount = 0;
        for (String word : words) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                int count = countConstruct(suffix, words);
                totalCount += count;
            }
        }
        return totalCount;
    }

    private static final Map<String, Integer> memo = new HashMap<>();

    private static int countConstructMemo(String target, String[] words) {
        if (target.isEmpty()) {
            return 1;
        }
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        int totalCount = 0;

        for (String word : words) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                int count = countConstructMemo(suffix, words);
                totalCount += count;
            }
        }
        memo.put(target, totalCount);
        return totalCount;
    }


}

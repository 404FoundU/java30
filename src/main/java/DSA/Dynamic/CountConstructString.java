package DSA.Dynamic;

import java.util.HashMap;
import java.util.Map;


// decision problem
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

    private static final Map<String, Boolean> memo = new HashMap<>();

    private static boolean canConstructMemo(String target, String[] words) {
        if (target.isEmpty()) {
            return true;
        }
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        for (String word : words) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                if (canConstructMemo(suffix, words)) {
                    memo.put(suffix, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;
    }


}

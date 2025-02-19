package DSA.Dynamic;

import java.util.HashMap;
import java.util.Map;


// decision problem
public class CanConstructString {

    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
    }

    private static boolean canConstruct(String target, String[] words) {

        if (target.isEmpty()) {
            return true;
        }

        for (String word : words) {

            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                if (canConstruct(suffix, words)) {
                    return true;
                }
            }

        }
        return false;

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

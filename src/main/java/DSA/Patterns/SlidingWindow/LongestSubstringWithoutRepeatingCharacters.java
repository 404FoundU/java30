package DSA.Patterns.SlidingWindow;

import java.util.HashSet;
import java.util.Set;


//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int l = 0;
        int maxSubstringLength = 0;
        Set<Character> set = new HashSet<>();
        for (int r = 0; r < charArray.length; r++) {
            while (set.contains(charArray[r])) {
                // remove the character at l and then move l
                set.remove(charArray[l]);
                l++;
            }
            set.add(charArray[r]);
            maxSubstringLength = Math.max(maxSubstringLength, r - l + 1);
        }
        return maxSubstringLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s)); // Output: 3
    }
}

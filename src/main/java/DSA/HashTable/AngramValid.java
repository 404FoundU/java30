package DSA.HashTable;

/*
https://leetcode.com/problems/valid-anagram/description/
 */
public class AngramValid {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int ascii = (int) c - 97;
            count[ascii]++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = s.charAt(i);
            int ascii = (int) c - 97;
            count[ascii]--;
        }
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s, t));  // Expected Output: false
    }
}

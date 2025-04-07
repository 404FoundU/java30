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

    private boolean testMethod(String str1, String str2) {
        HashTable<Character, Integer> hs = new HashTable<>();

        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (hs.get(ch) == null) {
                hs.put(ch, 1);
            } else {
                Integer count = hs.get(ch);
                hs.put(ch, count + 1);
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if (hs.get(ch) == null) {
                return false;
            } else {
                Integer count = hs.get(ch);
                if (count < 1) {
                    return false;
                }
                hs.put(ch, count - 1);
            }
        }

        for (HashTable.Node<Character, Integer> entry : hs.entrySet()) {
            if (entry.getValue() > 0) {
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

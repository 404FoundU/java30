package DSA.HashTable;


import java.util.ArrayList;
import java.util.List;

public class FindFirstNonRepeatingChar {


    public static void main(String[] args) {
        FindFirstNonRepeatingChar test = new FindFirstNonRepeatingChar();
        String str = "leetcode";
        String chr = test.testMethod(str);
        System.out.println(chr);
    }

    private String testMethod(String str) {
        HashTable<String, Integer> hs = new HashTable<>();
        String[] chars = str.split("");
        for (int i = 0; i < chars.length; i++) {
            String aChar = chars[i];
            if (hs.get(aChar) == null) {
                hs.put(aChar, 1);
            } else {
                Integer count = hs.get(aChar);
                hs.put(aChar, count + 1);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            String aChar = chars[i];
            if (hs.get(aChar) == 1) {
                return aChar;
            }
        }

        return null;
    }
}

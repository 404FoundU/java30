package DSA.HashTable;


import java.util.ArrayList;
import java.util.List;

public class AnagramsKAnagramsString {


    public static void main(String[] args) {
        AnagramsKAnagramsString test = new AnagramsKAnagramsString();
        String str1 = "fodre";
        String str2 = "gorke";
        System.out.println(test.testMethod(str1, str2, 2));

    }

    private boolean testMethod(String str1, String str2, int k) {
        HashTable<Character, Integer> hs = new HashTable<>();
        if (str1.length() != str2.length()) {
            return false;
        }

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
            if (hs.get(ch) != null) {
                Integer count = hs.get(ch);
                hs.put(ch, count - 1);
            } else {
                hs.put(ch, 1);
            }
        }
        List<Character> list = new ArrayList<>();
        for (HashTable.Node<Character, Integer> entry : hs.entrySet()) {
            if (entry.getValue() > 0) {
                list.add(entry.getKey());
            }
        }
        if (list.size() <= k * 2) {
            return true;
        }

        return false;
    }

}

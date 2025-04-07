package DSA.HashTable;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/group-anagrams/description/
 */
public class AnagramsGroup {


    public static void main(String[] args) {
        AnagramsGroup test = new AnagramsGroup();
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        HashTable<String, List<String>> hashTable = test.testMethod(str);
        for (HashTable.Node<String, List<String>> hst : hashTable.entrySet()) {
            System.out.println(hst.getValue());
        }
    }

    private HashTable<String, List<String>> testMethod(String[] str) {
        HashTable<String, List<String>> hs = new HashTable<>();

        for (String s : str) {
            String sorted = sortString(s);
            if (hs.get(sorted) == null) {
                List<String> anagrams = new LinkedList<>();
                anagrams.add(s);
                hs.put(sorted, anagrams);
            } else {
                List<String> strings = hs.get(sorted);
                strings.add(s);
                hs.put(sorted, strings);
            }
        }

        return hs;


    }

    public static String sortString(String str) {
        // Convert the string to a character array
        char[] charArray = str.toCharArray();

        // Sort the character array
        Arrays.sort(charArray);

        // Convert the sorted character array back to a string
        return new String(charArray);
    }
}

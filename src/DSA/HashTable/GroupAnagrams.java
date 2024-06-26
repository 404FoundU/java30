package DSA.HashTable;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {


    public static void main(String[] args) {
        GroupAnagrams test = new GroupAnagrams();
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        HashTable<String, List<String>> hashTable = test.testMethod(str);
        for (HashTable.Node<String, List<String>> hst : hashTable.getAllEntries()) {
            System.out.println(hst.getValue());
        }
    }

    private HashTable<String, List<String>> testMethod(String[] str) {
        List<String> anagrams = new ArrayList<>();
        HashTable<String, List<String>> hs = new HashTable<>();

        for (String s : str) {
            String sorted = sortString(s);
            if (hs.get(sorted) == null) {
                hs.put(sorted, new ArrayList<>());
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

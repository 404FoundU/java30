package DSA.HashTable;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-anagrams/description/
public class AnagramsGroup2 {
    public static void main(String[] args) {
        AnagramsGroup2 test = new AnagramsGroup2();
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<String, List<String>> hashTable = test.testMethod(str);
        for (Map.Entry<String, List<String>> entry : hashTable.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print("->");
            System.out.println(entry.getValue());
        }
    }

    private Map<String, List<String>> testMethod(String[] words) {
        Map<String, List<String>> result = new HashMap<>();

        for (String word : words) {
            String sortedWord = sortString(word);
            if (result.containsKey(sortedWord)) {
                result.get(sortedWord).add(word);
            } else {
                List<String> newWordList = new ArrayList<>();
                newWordList.add(word);
                result.put(sortedWord, newWordList);
            }
        }
        return result;
    }

    public static String sortString(String str) {
        char[] chArray = str.toCharArray();
        Arrays.sort(chArray);
        String s = String.valueOf(chArray);
        return s;
    }
}

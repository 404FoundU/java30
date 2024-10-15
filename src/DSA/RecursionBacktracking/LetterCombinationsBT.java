package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.youtube.com/watch?v=Nabbpl7y4Lo&t=195s
public class LetterCombinationsBT {


    public static void main(String[] args) {
        Map<String, String> phone = new HashMap<>();
        phone.put("2", "abc");
        phone.put("3", "def");
        phone.put("4", "ghi");
        phone.put("5", "jkl");
        phone.put("6", "mno");
        phone.put("7", "pqrs");
        phone.put("8", "tuv");
        phone.put("9", "wxyz");

        combinations(phone);
        System.out.println(result);
    }

    static List<List<Character>> result = new ArrayList<>();

    public static List<List<Character>> combinations(Map<String, String> map) {
//        backtrack(arr, new ArrayList<>(), 0);
        return result;
    }


}


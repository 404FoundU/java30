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

        combinations(phone, "23");
        System.out.println(result);
    }

    static List<String> result = new ArrayList<>();

    public static List<String> combinations(Map<String, String> phone, String number) {
        if (number.equals(" ")) {
            return new ArrayList<>();
        }

        backtrack(phone, number, new ArrayList<>(), 0);
        return result;
    }

    public static void backtrack(Map<String, String> map, String number, List<String> sol, int start) {
        // Add the current combination to the result
        if (sol.size() == number.length()) {

            StringBuilder res = new StringBuilder();
            for (String a : sol) {
                res.append(a);
            }
            result.add(res.toString()); // Make a copy of the combination
            return;
        }

        String num = String.valueOf(number.charAt(start));
        String letters = map.get(num);
        // Explore further combinations
        for (int i = 0; i < letters.length(); i++) {
            String letter = letters.substring(i, i + 1);  // Each character as a String
            sol.add(letter);
            // Move to the next element (adjust start index for the next recursion)

            backtrack(map, number, sol, start + 1);
            // Undo choice (remove the last added element)

            sol.remove(sol.size() - 1);
        }


    }
}


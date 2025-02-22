package DSA.Arrays.Strings;

import java.util.Stack;

public class ReverseWords {
    public static String reverseWords(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        Stack<String> stack = new Stack<>();
        for (String word : words) {
            stack.push(word); // push words to stack
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Hello World!")); // Output: "World! Hello"
        System.out.println(reverseWords("  Java   is  fun  ")); // Output: "fun is Java"
    }
}


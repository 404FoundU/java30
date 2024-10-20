package DSA.Stack;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {

    public static final Map<String, String> paraMap = new HashMap<>();

    public static void main(String[] args) {
        ValidParanthesis test = new ValidParanthesis();


        boolean b = test.testMethod("(){}[]");
        System.out.println(b);

    }

    public Map<Character, Character> getParaMap() {
        Map<Character, Character> paraMap = new HashMap<>();
        paraMap.put('(', ')');
        paraMap.put('{', '}');
        paraMap.put('[', ']');
        return paraMap;
    }

    private boolean testMethod(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }

        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}

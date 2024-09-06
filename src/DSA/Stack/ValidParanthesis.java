


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
        char[] charArray = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> paraMap = getParaMap();
        for (char c : charArray) {
            if (paraMap.containsKey(c)) {
                stack.push(c);
            } else {
                Character c2 = stack.pop();
                if (paraMap.get(c2) != c) {
                    return false;
                }

            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}

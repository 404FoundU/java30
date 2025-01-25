package DSA.RecursionBacktracking;


public class Palindrome {
    public static void main(String[] args) {
        Palindrome test = new Palindrome();
        test.testMethod("abba");
        test.testMethod("abbaa");
    }

    private void testMethod(String str) {

        boolean b = _testMethod(str, 0, str.length() - 1);
        System.out.println(str + " = " + b);

    }

    private boolean _testMethod(String str, int left, int right) {
        if (left > right) {
            return true;
        }
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        return _testMethod(str, left + 1, right - 1);
    }

    private boolean testMethod2(String p) {

        char[] a = p.toCharArray();

        int start = 0;
        int length = a.length;
        int end = length - 1;
        while (start < end) {
            if (a[start] != a[end]) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }


}

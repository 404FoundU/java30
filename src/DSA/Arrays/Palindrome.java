package DSA.Arrays;


import java.util.Objects;

public class Palindrome {
    public static void main(String[] args) {
        Palindrome test = new Palindrome();
        String p = "abcba";
        test.testMethod(p);
    }

    private boolean testMethod(String p) {

        char[] a = p.toCharArray();

        int start = 0;
        int length = a.length;
        int end = length - 1;
        while (start < end) {
            if (a[start] != a[end]) {
                return                false;
            }

            start++;
            end--;
        }

        return true;
    }


}

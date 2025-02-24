package DSA.Arrays.Strings;

public class StringRotationCheck {
    public static boolean isRotation(String str1, String str2) {
        // Check if lengths are different
        if (str1.length() != str2.length()) {
            return false;
        }

        // Concatenate str1 with itself
        String concatenated = str1 + str1;

        // Check if str2 is a substring of concatenated
        return concatenated.contains(str2);
    }

    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "defabc";

        if (isRotation(str1, str2)) {
            System.out.println(str2 + " is a rotation of " + str1);
        } else {
            System.out.println(str2 + " is NOT a rotation of " + str1);
        }
    }
}


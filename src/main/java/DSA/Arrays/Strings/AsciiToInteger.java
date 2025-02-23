package DSA.Arrays.Strings;

public class AsciiToInteger {
    public static void main(String[] args) {
        AsciiToInteger solver = new AsciiToInteger();
        System.out.println(solver.myAtoi("42")); // Output: 42
        System.out.println(solver.myAtoi("   -42")); // Output: -42
        System.out.println(solver.myAtoi("4193 with words")); // Output: 4193
        System.out.println(solver.myAtoi("words and 987")); // Output: 0
        System.out.println(solver.myAtoi("-91283472332")); // Output: -2147483648
    }

    public static int myAtoi(String str) {
        str = str.trim(); // Remove leading/trailing spaces
        if (str.isEmpty()) return 0; // Handle empty string

        int i = 0, sign = 1, num = 0;

        // Check for optional '+' or '-' sign to be used in the end
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            sign = (str.charAt(0) == '-') ? -1 : 1;
            i++;
        }

        // Convert digits to integer
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = Integer.valueOf(String.valueOf(str.charAt(i)));

            // Handle overflow before multiplying
            if (num > (Integer.MAX_VALUE / 10) || (num == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            num = num * 10 + digit;
            i++;
        }

        return num * sign;
    }

}

package DSA.Arrays.Strings;

//https://leetcode.com/problems/string-compression/description/
public class StringCompression {
    public int compress(char[] chars) {
        int write = 0, read = 0, n = chars.length;

        while (read < n) {
            char ch = chars[read];
            int count = 0;

            // Count consecutive occurrences
            while (read < n && chars[read] == ch) {
                count++;
                read++;
            }

            // Write character
            chars[write++] = ch;

            // Write count if greater than 1
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write; // New length of compressed array
    }

    public static void main(String[] args) {
        StringCompression solver = new StringCompression();

        char[] chars1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(solver.compress(chars1)); // Output: 6 (chars = ['a', '2', 'b', '2', 'c', '3'])

        char[] chars2 = {'a'};
        System.out.println(solver.compress(chars2)); // Output: 1 (chars = ['a'])

        char[] chars3 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(solver.compress(chars3)); // Output: 4 (chars = ['a', 'b', '1', '0'])
    }
}


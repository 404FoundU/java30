package DSA.Arrays.Strings;

//https://leetcode.com/problems/string-compression/description/
/*
count = 2
i = 2
char i = b
char i - 1 = b
list = [ a
 */
public class StringCompression {
    public int compress(char[] chars) {
        int index = 0; // Write index in chars[]
        int i = 0; // Read index in chars[]

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count occurrences of currentChar
            while (i < chars.length && chars[i] == currentChar) {
                count++;
                i++;
            }

            // Write the character
            chars[index++] = currentChar;

            // Write the count if greater than 1
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index; // New length of the compressed array
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





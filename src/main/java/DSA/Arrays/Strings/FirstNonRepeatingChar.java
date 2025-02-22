package DSA.Arrays.Strings;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        System.out.println(testMethod("aabbbcddd"));
    }

    private static char testMethod(String str) {
        int[] asciiFrequency = new int[255];
        for (char c : str.toCharArray()) {
            //char to ascii
            Integer i = Integer.valueOf(c);
            asciiFrequency[i]++;
        }
        for (int i = 0; i < asciiFrequency.length; i++) {
            if (asciiFrequency[i] == 0) {
                return (char) i;
            }
        }
        return '\0';
    }


}

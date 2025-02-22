package DSA.Arrays.Strings;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        System.out.println(testMethod("aabbbcddd"));

    }

    private static char testMethod(String str) {
        int[] frequency = new int[255];
        for (char c : str.toCharArray()) {
            frequency[c]++;
        }


        // ch to int
        //'5' to 5
        //'125' to 5

        Integer i = Integer.valueOf('A');
        int i1 = Integer.parseInt("123");
        System.out.println(i);

        String s = String.valueOf(i);

        System.out.println(s);

        return 'A';
    }


}

package DSA.Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Array1 {
    public static void main(String[] args) {
        Array1 test = new Array1();
        test.testMethod();
    }

    private void testMethod() {
        int[] intArr = new int[5]; // 0,0,0,0,0
        Arrays.fill(intArr, 1);
        int length = intArr.length;
        int[] intArr2 = {1, 2, 3, 4, 5};
        int[] intArr3 = new int[]{1, 2, 3, 4, 5};
        intArr2[4] = Integer.MIN_VALUE; // delete element 2^ -31
        int[] emptyArr = {};
        int[] emptyArr2 = new int[]{};
        intArr[0] = 1;

        Integer[] intArr4 = new Integer[]{1, 2, 3, 4, 5};
        List<Integer> intList = Arrays.asList(intArr4);
        List<String> list = Arrays.asList("unni", "pillai");
        String[] array = {"apple", "banana", "cherry"};
        List<String> list1 = Arrays.asList(array);
        List<Integer> integers = List.of(1, 2, 3);// Immutable - cannot add or remove, faster, no primitives
        int[] intArray = integers.stream().mapToInt(i -> i).toArray();
        List<String> name = new ArrayList<>(list);
        List<List<String>> result = new ArrayList<>();
        List<Integer> multithreadList = Collections.synchronizedList(new ArrayList<>());
        Arrays.stream(intArr2).forEach(System.out::println);
        System.out.println(Arrays.toString(new int[]{1, 2}));
        int[][] board = {
                {7, 0, 2, 0, 5, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 0, 9, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 3, 0, 0, 0, 7, 5, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };
        int[][][] array3D = {
                {{1, 2, 10}, {3, 4, 11}},
                {{5, 6, 12}, {7, 8, 13}}
        };

    }

    public static String sortString(String str) {
        // Convert the string to a character array
        char[] charArray = str.toCharArray();

        // Sort the character array
        Arrays.sort(charArray);
        String original = "Hello";
        String result = "Hello".substring(0);
        // Convert the sorted character array back to a string
        return new String(charArray);
    }


}

package DSA.Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array1 {
    public static void main(String[] args) {
        Array1 test = new Array1();
        test.testMethod();
    }

    private void testMethod() {
        int[] intArr = new int[5]; // 0,0,0,0,0
        int length = intArr.length;
        int[] intArr2 = {1, 2, 3, 4, 5};
        intArr[0] = 1;

        int[] intArr3 = new int[] {1, 2, 3, 4, 5};
        Integer[] intArr4 = new Integer[] {1, 2, 3, 4, 5};
        List<String> list = Arrays.asList("unni", "pillai");
        List<Integer> integers = List.of(1, 2, 3);// Immutable - cannot add or remove, faster, no primitives
        List<String> name = new ArrayList<>(list);
        Arrays.stream(intArr2).forEach(System.out::println);
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

    }


}

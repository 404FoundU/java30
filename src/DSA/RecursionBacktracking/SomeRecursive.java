package DSA.RecursionBacktracking;

import java.util.Arrays;

public class SomeRecursive {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 9};

        OddFunction isOdd = (int number) -> number % 2 != 0;
        boolean result = someRecursive(numbers, isOdd);

        System.out.println("Contains odd number: " + result);
    }

    public static boolean someRecursive(int[] arr, OddFunction odd) {
        if (arr.length == 0) {
            return false;
        } else if (odd.run(arr[0]) == false) {
            return someRecursive(Arrays.copyOfRange(arr, 1, arr.length), odd);
        } else {
            return true;
        }
    }


}

@FunctionalInterface
interface OddFunction {
    boolean run(int number);
}

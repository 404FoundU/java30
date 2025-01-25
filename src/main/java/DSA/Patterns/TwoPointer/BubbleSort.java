package DSA.Patterns.TwoPointer;


import java.util.Arrays;

import static DSA.Utility.swapArrayIndexes;

//https://www.youtube.com/watch?v=g8qeaEd2jTc
public class BubbleSort { // O(n^2) due to 2 loops
    public static void main(String[] args) {
        BubbleSort test = new BubbleSort();
        int[] arr = {-5, 3, 2, 1, -3, -3, 7, 2, 2};
        test.testMethod(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void testMethod(int[] arr) {
        boolean swappedSomething = true;
        while (swappedSomething) { // we need to run the for loop again
            swappedSomething = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > arr[i - 1]) {
                    swappedSomething = true;
                    swapArrayIndexes(arr, i, i - 1);
                }
            }
        }
    }


}

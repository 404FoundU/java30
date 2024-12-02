package DSA.Patterns.TwoPointer;


import java.util.Arrays;

import static DSA.Utility.SwapArrayIndexes;
import static DSA.Utility.getRandomArray;

//https://youtu.be/gcRUIO-8r3U?t=266&si=63TAWD59f5ICWiBP
public class InsertionSort { // O(n^2) due to 2 loops
    public static void main(String[] args) {

        int[] arr = getRandomArray();
        InsertionSort test = new InsertionSort();
        test.testMethod(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void testMethod(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) { // compare previous element
                    SwapArrayIndexes(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }


}

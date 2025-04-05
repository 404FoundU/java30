package DSA.Patterns.TwoPointer;


import java.util.Arrays;

import static DSA.Utility.getRandomArray;
import static DSA.Utility.swapArrayIndexes;

//https://youtu.be/gcRUIO-8r3U?t=513&si=exE30xD_1s5aMeak
public class MinSelectionSort { // O(n^2) due to 2 loops
    public static void main(String[] args) {

        int[] arr = getRandomArray();
        MinSelectionSort test = new MinSelectionSort();
        test.testMethod(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void testMethod(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { //iterate whole array and find min
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swapArrayIndexes(arr, i, minIndex);
        }
    }


}

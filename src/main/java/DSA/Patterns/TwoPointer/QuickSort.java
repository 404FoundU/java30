package DSA.Patterns.TwoPointer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static DSA.Utility.getRandomArray;
import static DSA.Utility.integerListToArray;

//https://youtu.be/gcRUIO-8r3U?t=1410&si=DJPKBxCqve_f0BTf
public class QuickSort { // O(n log n) dividing by half
    public static void main(String[] args) {

        int[] arr = getRandomArray();
        QuickSort test = new QuickSort();
        int[] sorted = test.quickSort(arr);
        System.out.println(Arrays.toString(sorted));
    }

    public int[] quickSort(int[] arr) {
        if (arr.length <= 1) {
            return arr; // Base case: If the array has 1 or 0 elements, it's already sorted
        }

        int pivot = arr[arr.length - 1]; // Choose the last element as the pivot
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        // Partitioning: Separate elements into left and right lists
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] <= pivot) {
                left.add(arr[i]);
            } else {
                right.add(arr[i]);
            }
        }

        // Recursively sort the left and right lists
        int[] leftSorted = quickSort(integerListToArray(left));
        int[] rightSorted = quickSort(integerListToArray(right));

        // Combine the sorted left, pivot, and sorted right
        return concatenate(leftSorted, pivot, rightSorted);
    }

    private int[] concatenate(int[] leftArray, int pivot, int[] rightArray) {
        int[] result = new int[leftArray.length + 1 + rightArray.length];
        int index = 0;
        for (int e : leftArray) {
            result[index++] = e;
        }
        result[index++] = pivot;
        for (int e : rightArray) {
            result[index++] = e;
        }
        return result;
    }


}

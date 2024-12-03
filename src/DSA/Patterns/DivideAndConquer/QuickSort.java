package DSA.Patterns.DivideAndConquer;


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
        test.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private int[] quickSort(int[] arr) {

        if (arr.length <= 1) {
            return arr;
        }
        int pivot = arr[arr.length - 1];

        List<Integer> leftArrayList = new ArrayList<>();
        List<Integer> rightArrayList = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] <= pivot) {
                leftArrayList.add(arr[i]);
            } else {
                rightArrayList.add(arr[i]);
            }
        }

        int[] leftArray = quickSort(integerListToArray(leftArrayList));
        int[] rightArray = quickSort(integerListToArray(rightArrayList));

        return concatanate(leftArray, pivot, rightArray);


    }

    private int[] concatanate(int[] leftArray, int pivot, int[] rightArray) {
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

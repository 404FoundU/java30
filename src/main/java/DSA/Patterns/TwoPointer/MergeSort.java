package DSA.Patterns.TwoPointer;


import java.util.Arrays;

import static DSA.Utility.getRandomArray;

//https://www.youtube.com/watch?v=bOk35XmHPKs
public class MergeSort { // O(n log n) dividing by half
    public static void main(String[] args) {

        int[] arr = getRandomArray();
        MergeSort test = new MergeSort();
        test.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void mergeSort(int[] arr) {
        int length = arr.length;

        if (length == 1) {
            return;
        }
        int mid = length / 2;
        int rest = length - mid;

        int[] leftArray = new int[mid];
        System.arraycopy(arr, 0, leftArray, 0, mid);
        int[] rightArray = new int[rest];
        System.arraycopy(arr, mid, rightArray, 0, rest);
        /*System.out.println("leftArray = " + Arrays.toString(leftArray));
        System.out.println("rightArray = " +  Arrays.toString(rightArray));*/
        mergeSort(leftArray);
        mergeSort(rightArray);

        mergeSortedArray(arr, leftArray, rightArray);
    }

    // merge the sorted halfs
    private void mergeSortedArray(int[] arr, int[] leftArray, int[] rightArray) {
        int length = arr.length;
        int l = 0;
        int r = 0;
        int k = 0;
        int min = Integer.MIN_VALUE;
        while (l < leftArray.length && r < rightArray.length) {
            if (leftArray[l] < rightArray[r]) {
                min = leftArray[l];
                l++;
            } else {
                min = rightArray[r];
                r++;
            }
            arr[k] = min;
            k++;
        }
        // copy rest of the elements from bigger half
        while (l < leftArray.length) {
            arr[k] = leftArray[l];
            l++;
            k++;
        }
        while (r < rightArray.length) {
            arr[k] = rightArray[r];
            r++;
            k++;
        }
    }


}

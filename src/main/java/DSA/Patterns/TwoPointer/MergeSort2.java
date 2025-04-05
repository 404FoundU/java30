package DSA.Patterns.TwoPointer;


import java.util.Arrays;

import static DSA.Utility.getRandomArray;

//https://www.youtube.com/watch?v=bOk35XmHPKs
public class MergeSort2 { // O(n log n) dividing by half
    public static void main(String[] args) {

        int[] arr = getRandomArray();
        MergeSort2 test = new MergeSort2();
        test.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void mergeSort(int[] arr) {
        if (arr.length == 1) {
            return;
        }
        int n = arr.length;
        int mid = n / 2;
        int[] left = new int[mid];
        int rLength = arr.length - mid;
        int[] right = new int[rLength];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, rLength);

        mergeSort(left);
        mergeSort(right);
        mergeSortedHalfs(arr, left, right);
    }

    // merge the sorted halfs
    void mergeSortedHalfs(int[] arr, int[] left, int[] right) {
        int i = 0;
        int l = 0;
        int r = 0;
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                arr[i] = left[l];
                l++;
            } else if (left[l] > right[r]) {
                arr[i] = right[r];
                r++;
            }
            i++;
        }
        // copy rest
        if (l > r) {
            while (l < left.length) {
                arr[i] = arr[l];
                l++;
                i++;
            }
        }
        if (l < r) {
            while (r < right.length) {
                arr[i] = arr[r];
                r++;
                i++;
            }
        }
    }

}

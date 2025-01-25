package DSA.Patterns.TwoPointer;


import java.util.Arrays;

import static DSA.Utility.getRandomArray;
import static DSA.Utility.swapArrayIndexes;

//https://www.youtube.com/watch?v=h8eyY7dIiN4
public class QuickSortTwoPointer { // O(n^2 worst case pivot, avg is n log n) dividing by half
    public static void main(String[] args) {

        int[] arr = getRandomArray();
        QuickSortTwoPointer test = new QuickSortTwoPointer();
        test.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    public void quickSortHelper(int[] arr, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) {// only one element
            return;
        }
        int pivot = arr[highIndex];
        int l = lowIndex;
        int r = highIndex;

        while (l < r) {
            //walk from left to right until you find an element greater than pivot or pass right pointer
            while (arr[l] <= pivot && l < r) {
                l++;
            }
            while (arr[r] >= pivot && l < r) {
                r--;
            }
            // swap the numbers since larger is on left of pivot and smaller is on right of pivot
            swapArrayIndexes(arr, l, r);
        }
        // once l and r pointers meet swap the pivot with the left pointer
        swapArrayIndexes(arr, l, highIndex);

        // quick sort left and right without old pivot. pivot is in correct place
        quickSortHelper(arr, lowIndex, l - 1);
        quickSortHelper(arr, l + 1, highIndex);

    }


}

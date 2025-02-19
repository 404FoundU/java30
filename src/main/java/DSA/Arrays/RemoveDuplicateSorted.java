package DSA.Arrays;

import java.util.Arrays;

public class RemoveDuplicateSorted {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4};
        int newLength = removeDuplicates(arr);
        System.out.println("Unique Array: " + Arrays.toString(Arrays.copyOf(arr, newLength))); // Output: [1, 2, 3, 4]
    }

    private static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;

        int index = 1; // Pointer for placing unique elements
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) { // New unique element found
                arr[index] = arr[i];
                index++;
            }
        }
        return index; // New array length
    }
}


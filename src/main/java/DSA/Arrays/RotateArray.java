package DSA.Arrays;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2; // Number of rotations
        rotate(arr, k);
        System.out.println("Rotated Array: " + Arrays.toString(arr)); // Output: [4, 5, 1, 2, 3]
    }

    private static void rotate(int[] arr, int k) {
        int n = arr.length;
        if (n == 0 || k % n == 0) return; // Edge case: No rotation needed

        k = k % n; // Handle cases where k > n

        // Step 1: Reverse the entire array
        reverse(arr, 0, n - 1);

        // Step 2: Reverse first k elements
        reverse(arr, 0, k - 1);

        // Step 3: Reverse remaining elements
        reverse(arr, k, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}


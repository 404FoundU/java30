package DSA.Arrays;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        mergeSorted(nums1, m, nums2, n);
        System.out.println("Merged Array: " + Arrays.toString(nums1));
    }

    public static void mergeSorted(int[] nums1, int m, int[] nums2, int n) {
        int x = m - 1; // Pointer for nums1
        int y = n - 1; // Pointer for nums2
        int z = m + n - 1; // Pointer for placement in nums1

        // Merge from the back
        while (x >= 0 && y >= 0) {
            if (nums1[x] > nums2[y]) {
                nums1[z] = nums1[x];
                x--;
            } else {
                nums1[z] = nums2[y];
                y--;
            }
            z--;
        }

        // If there are remaining elements in nums2, copy them over
        while (y >= 0) {
            nums1[z] = nums2[y];
            y--;
            z--;
        }
    }

}



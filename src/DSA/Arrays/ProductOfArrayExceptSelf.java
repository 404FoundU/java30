package DSA.Arrays;

import java.util.Arrays;

//https://www.youtube.com/watch?v=DYwBZIFMoTk
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] nums = {1, -2, 3, -4, 5};
        productOfArrayExceptSelf.test(nums);

    }

    private int test(int[] nums) {

        int[] arr = new int[nums.length];
        int right = 1;
        int left = 1;
        for (int i = nums.length - 1; i >= 0; i--) {

            arr[i] = right;
            right = nums[i] * right;

        }
        System.out.println("arr = " + Arrays.toString(arr));

        for (int j = 0; j < nums.length; j++) {
            arr[j] = arr[j] * left;
            left = left * nums[j];
        }
        System.out.println("arr = " + Arrays.toString(arr));

        return 0;
    }
}

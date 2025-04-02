package DSA.Dynamic;

public class MaxProductSubArray {

    public static int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFAr = nums[0];
        int maxProduct = nums[0];

        for (int num : nums) {
            int tempMax = maxSoFar;
            maxSoFar = Math.max(num, Math.max(maxSoFar * num, minSoFAr * num));
            minSoFAr = Math.min(num, Math.min(tempMax * num, minSoFAr * num));

            maxProduct = Math.max(maxSoFar, minSoFAr);
        }
        return maxProduct;
    }


    public static int maxProductBF(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println("Max Product: " + maxProduct(nums));
    }
}

/*
Index	Num	  maxSoFar	                   minSoFar	                result
0	    2	  2	                          2	                            2
1	    3	  max(3, 2×3, 2×3) = 6	      min(3, 2×3, 2×3) = 3	        6
2	    -2	  max(-2, 6×-2, 3×-2) = -2	  min(-2, 6×-2, 3×-2) = -12	    6
3	    4	  max(4, -2×4, -12×4) = 4	  min(4, -2×4, -12×4) = -48	    6

 */


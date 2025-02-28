package DSA.Patterns.SlidingWindow;

//https://leetcode.com/problems/max-consecutive-ones-iii/description/
//https://www.youtube.com/watch?v=HsGKI02yw6M&list=PLKYEe2WisBTFZH-p9jgAOwtHy9_LGI28W
public class MaxConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {
        int left = 0, maxWindow = 0, zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroCount++; // Count zeroes in the window

            // If zeroes exceed k, shrink the window from the left
            while (zeroCount > k) {
                if (nums[left] == 0) zeroCount--;
                left++; // Move left to reduce zero count
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return maxWindow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes(nums, k)); // Output: 6
    }
}



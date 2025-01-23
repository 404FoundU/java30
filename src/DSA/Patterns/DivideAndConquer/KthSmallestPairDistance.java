package DSA.Patterns.DivideAndConquer;

import java.util.Arrays;

//https://leetcode.com/problems/find-k-th-smallest-pair-distance/
//https://www.youtube.com/watch?v=VE6-iLUQ7gU
public class KthSmallestPairDistance {
    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {1, 3, 1};
        int k1 = 1; // Expected output: 0

        int[] nums2 = {1, 1, 1};
        int k2 = 2; // Expected output: 0

        int[] nums3 = {1, 6, 1};
        int k3 = 3; // Expected output: 5

        System.out.println(findKthSmallestPairDistance(nums1, k1));
        System.out.println(findKthSmallestPairDistance(nums2, k2));
        System.out.println(findKthSmallestPairDistance(nums3, k3));
    }

    // binary search on Answer - here answer is absolute diff
    public static int findKthSmallestPairDistance(int[] nums, int k) {
        // Step 1: Sort the array
        Arrays.sort(nums);


        // when nums[131] is sorted [113] smallest is num[0] and largest is last
        int left = 0; // Minimum possible distance
        int right = nums[nums.length - 1] - nums[0]; // Maximum  absolute difference

// we have to find the kth smallest pair
        while (left < right) {
            int mid = left + (right - left) / 2;

             /*
    eg: mid=4 and noOfPairs having absolute diff >=k is 6.
    We need to reduce 6 to k by moving right to mid
     */
            if (countPairs(nums, mid) >= k) {
                right = mid; // Narrow search to smaller distances
            } else {
                //pairs have absolute diff less than k. So increase left
                left = mid + 1; // Increase distance
            }
        }

        return left; // The k-th smallest distance
    }
    //is it possible to have pairs with distances >=k and has abs diff more than mid


    private static int countPairs(int[] nums, int mid) {
        int noOfPairs = 0;
        int left = 0;

        // Step 3: Count pairs with distance <= mid
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > mid) {
                left++; // Move the left pointer to maintain the distance condition
            }
            noOfPairs += right - left; // All pairs between [left, right] are valid
        }

        return noOfPairs;
    }
}


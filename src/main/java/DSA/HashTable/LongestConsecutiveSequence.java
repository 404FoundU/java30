package DSA.HashTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://www.youtube.com/watch?v=joIEdeOGqjQ
public class LongestConsecutiveSequence {
    public static int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            // check left
            int leftElement = nums[i] - 1;
            int currentStreak = 1;

            if (!set.contains(leftElement)) {
                int nextElement = nums[i] + 1;
                while (set.contains(nextElement)) {
                    nextElement++;
                    currentStreak++;
                }
                maxLength = Math.max(currentStreak, maxLength);
            }

        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
//        System.out.println("Longest consecutive sequence length: " + longestConsecutive(nums1)); // Output: 4
        System.out.println("Longest consecutive sequence length: " + longestConsecutive2(nums1)); // Output: 4

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
//        System.out.println("Longest consecutive sequence length: " + longestConsecutive(nums2)); // Output: 9
        System.out.println("Longest consecutive sequence length: " + longestConsecutive2(nums2)); // Output: 9
    }

    public static int longestConsecutiveBruteForce(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        int maxLength = 1;
        int currentStreak = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;

            if (nums[i] - nums[i - 1] == 1) {
                currentStreak++;
            } else {
                maxLength = Math.max(maxLength, currentStreak);
                currentStreak = 1;
            }
        }


        return maxLength;
    }


}


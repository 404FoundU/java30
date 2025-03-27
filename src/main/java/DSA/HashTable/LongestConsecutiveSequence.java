package DSA.HashTable;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Check if num is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
//        System.out.println("Longest consecutive sequence length: " + longestConsecutive(nums1)); // Output: 4
        System.out.println("Longest consecutive sequence length: " + longestConsecutiveBruteForce(nums1)); // Output: 4

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
//        System.out.println("Longest consecutive sequence length: " + longestConsecutive(nums2)); // Output: 9
        System.out.println("Longest consecutive sequence length: " + longestConsecutiveBruteForce(nums2)); // Output: 9
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


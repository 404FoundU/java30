package DSA.HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
        Arrays.sort(nums);
        Map<Integer, Integer> diffCountMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int diff = nums[j] - nums[i];
                if (diffCountMap.containsKey(diff)) {
                    int diffCount = diffCountMap.get(diff);
                    diffCountMap.put(diff, diffCount + 1);
                } else {
                    diffCountMap.put(diff, 1);
                }

            }
        }
       /* int maxCount = 0;

        for (Map.Entry<Integer, Integer> entry : diffCountMap.entrySet()) {
            maxCount = Math.max(maxCount, entry.getValue());

        }*/

        int maxCount = diffCountMap.values().stream()
                .max((a, b) -> a.compareTo(b))
                .orElse(0);


        return maxCount;
    }


}


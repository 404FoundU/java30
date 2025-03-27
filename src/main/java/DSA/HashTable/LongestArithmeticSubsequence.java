package DSA.HashTable;

public class LongestArithmeticSubsequence {
    public static int longestArithSeqLengthBF(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        int maxLength = 2;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = nums[j] - nums[i];
                int currLength = 2;
                int prev = nums[j];
                for (int k = j + 1; k < n; k++) {

                    if (diff == nums[k] - prev) {
                        currLength++;
                        prev = nums[k];
                    }
                }
                maxLength = Math.max(currLength, maxLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 6, 9, 12};
        int[] nums2 = {9, 4, 7, 2, 10};
        int[] nums3 = {20, 1, 15, 3, 10, 5, 8};

        System.out.println("Example 1: " + longestArithSeqLengthBF(nums1)); // 4
        System.out.println("Example 2: " + longestArithSeqLengthBF(nums2)); // 3
        System.out.println("Example 3: " + longestArithSeqLengthBF(nums3)); // 4
    }
}

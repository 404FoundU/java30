package DSA.HashTable;

public class LongestArithmeticSubsequence {
    public static int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;

        int maxLength = 2;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = nums[j] - nums[i];
                int length = 2;
                int prev = nums[j];

                for (int k = j + 1; k < n; k++) {
                    if (nums[k] - prev == diff) {
                        length++;
                        prev = nums[k];
                    }
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 6, 9, 12};
        int[] nums2 = {9, 4, 7, 2, 10};
        int[] nums3 = {20, 1, 15, 3, 10, 5, 8};

        System.out.println("Example 1: " + longestArithSeqLength(nums1)); // 4
        System.out.println("Example 2: " + longestArithSeqLength(nums2)); // 3
        System.out.println("Example 3: " + longestArithSeqLength(nums3)); // 4
    }
}

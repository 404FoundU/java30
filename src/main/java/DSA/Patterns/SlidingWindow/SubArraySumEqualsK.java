package DSA.Patterns.SlidingWindow;


//https://www.youtube.com/watch?v=EFzYA9H0MfQ
//https://leetcode.com/problems/subarray-sum-equals-k/description/
public class SubArraySumEqualsK {


    public static void main(String[] args) {
        SubArraySumEqualsK test = new SubArraySumEqualsK();

        // for positiver integers
        int[] ints = {1, 2, 3, 4, 5};
        int target = 9;
        System.out.println(subarraySumSW(ints, target));

    }

    public static int subarraySumSW(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > k && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                count++;
            }
        }

        return count;
    }


    public static int subarraySumBF(int[] nums, int k) {
        int count = 0;
        int n = nums.length;

        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += nums[end];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}

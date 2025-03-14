package DSA.Stack.MonotonicStack;

import java.util.Stack;

class Pattern132 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>(); // stack stores indices
        int third = Integer.MIN_VALUE;  // potential nums[k] value

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // nums[i] is nums[i], third is nums[k]
            if (nums[i] < third) {
                // nums[i] < nums[k], pattern found: nums[i] < nums[k] < nums[j]
                return true;
            }

            // nums[i] > nums[stack.peek()], update third(nums[k])
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                Integer top = stack.pop();
                third = nums[top];
            }

            // Push current index as potential nums[j]
            stack.push(i);
        }

        return false; // no pattern found
    }


    public static void main(String[] args) {
        Pattern132 solution = new Pattern132();

        int[] nums1 = {3, 1, 4, 2};   // true
        int[] nums2 = {-1, 3, 2, 0};  // true
        int[] nums3 = {1, 2, 3, 4};   // false

        System.out.println(solution.find132pattern(nums1));  // true
        System.out.println(solution.find132pattern(nums2));  // true
        System.out.println(solution.find132pattern(nums3));  // false
    }
}


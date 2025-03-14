package DSA.Stack.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);  // default -1 when no greater found
        Stack<Integer> stack = new Stack<>();

        // Iterate twice for circular handling
        for (int i = 0; i < 2 * n; i++) {
            int currentIndex = i % n; // wrap around using modulo

            // Check if current element is greater than stack top
            while (!stack.isEmpty() && nums[currentIndex] > nums[stack.peek()]) {
                int index = stack.pop();
                result[index] = nums[currentIndex];
            }

            // First iteration: push index onto stack
            if (i < n) {
                stack.push(currentIndex);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementII solution = new NextGreaterElementII();

        int[] nums = {1, 2, 1};
        int[] result = solution.nextGreaterElements(nums);

        System.out.println("Input : " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(result));
        // Output: [2, -1, 2]

        // Additional test
        int[] nums2 = {13, 8, 1, 5, 2, 5, 9, 7, 6, 12};
        int[] result2 = solution.nextGreaterElements(nums2);
        System.out.println("Input : " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(result2));
    }
}


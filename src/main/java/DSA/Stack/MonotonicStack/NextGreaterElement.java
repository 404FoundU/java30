package DSA.Stack.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/discuss/post/2347639/a-comprehensive-guide-and-template-for-m-irii/
class NextGreaterElement {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = arr[i];
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement solution = new NextGreaterElement();

        // Example array
        int[] arr = {13, 8, 1, 5, 2, 5, 9, 7, 6, 12};
        System.out.println(Arrays.toString(solution.nextGreaterElements(arr)));
        // Output: [-1, 9, 5, 9, 5, 9, 12, 12, 12, -1]
    }
}

package DSA.Stack.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/discuss/post/2347639/a-comprehensive-guide-and-template-for-m-irii/
class NextGreaterElement {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] nextGreaterArray = new int[n];
        Arrays.fill(nextGreaterArray, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // the element represented by stack top is STRICTLY SMALLER than the current element
            // This means, the stack will always be monotonic non increasing (type 4)
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int stackTop = stack.pop();
                // nextGreater element of stackTop is the element at index i
                nextGreaterArray[stackTop] = arr[i];
            }
            stack.push(i);
        }

        return nextGreaterArray;
    }

    public static void main(String[] args) {
        NextGreaterElement solution = new NextGreaterElement();

        // Example array
        int[] arr = {13, 8, 1, 5, 2, 5, 9, 7, 6, 12};
        System.out.println(Arrays.toString(solution.nextGreaterElements(arr)));
        // Output: [-1, 9, 5, 9, 5, 9, 12, 12, 12, -1]
    }
}

package DSA.Stack.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/discuss/post/2347639/a-comprehensive-guide-and-template-for-m-irii/
// immediate next greater and not the greatest

//https://www.youtube.com/watch?v=UMFKP9cTDtI
class NextGreaterElement {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] nextGreaterArray = new int[n];
        Arrays.fill(nextGreaterArray, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {


            // the element represented by stack top is STRICTLY SMALLER than the current element
            // Check if the current element is greater than stack top
            // This means, the stack will always be ( monotonic decreasing  ( monotonic non increasing (type 4) )

            // Pop until stack top > current element
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
/*
For finding next greater elements (not equal) we use a monotonic non increasing stack (type 4)
If the question was to find next greater or equal elements, then we would have used a monotonic strictly decreasing stack (type 3)
We use the operator < in while loop condition above - this results in a monotonic non increasing stack (type 4). If we use <= operator, then this becomes a monotonic strictly decreasing stack (type 3)
Time and space complexity - O(n)


arr:    [13,  8,  1,  5,  2,  5,  9,  7,  6, 12]
result: [-1,  9,  5,  9,  5,  9, 12, 12, 12, -1]

Stack-based resolution:
- [13] has no next greater → -1
- [8] next greater → 9
- [1] next greater → 5
- [5] next greater → 9
- [2] next greater → 5
- [5] next greater → 9
- [9] next greater → 12
- [7] next greater → 12
- [6] next greater → 12
- [12] no next greater → -1

 */

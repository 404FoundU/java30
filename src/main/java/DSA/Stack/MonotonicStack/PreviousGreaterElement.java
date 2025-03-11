package DSA.Stack.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

class PreviousGreaterElement {
    public int[] previousGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        //holds indices of previous greater elements, with -1 indicating no previous greater element exists.
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // the element represented by stack top is SMALLER OR EQUAL to the current element
            // This means, the stack will always be strictly decreasing (type 3) - because elements are popped when they are equal
            // so equal elements will never stay in the stack (definition of strictly decreasing stack)

            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            // after the while loop, only the elements which are greater than the current element are left in stack
            // this means we can confidentally decide the previous greater element of the current element i, that's stack top
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        PreviousGreaterElement solution = new PreviousGreaterElement();

        // Example array
        int[] arr = {13, 8, 1, 5, 2, 5, 9, 7, 6, 12};
        System.out.println(Arrays.toString(solution.previousGreaterElements(arr)));
        // Output: [-1, 0, 1, 1, 3, 1, 0, 6, 7, 0]
    }
}

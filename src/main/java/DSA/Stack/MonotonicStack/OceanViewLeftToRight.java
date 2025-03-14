package DSA.Stack.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

class OceanViewLeftToRight {
    public int[] findBuildings(int[] heights) {

        // in other words, we want to find which of the buildings
        // have a next greater element
        // at the end, the elements left in the stack will be the ones
        // which wouldn't have any greater elements after them
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // note the operator used is <=
            // because we want to pop out the buildings which have another
            // building with equal or greater height in view
            // this means the monotonic stack is going to be strictly decreasing
            // If current building is taller, remove shorter ones behind it.
            while (!stack.isEmpty() && heights[i] >= heights[stack.peek()]) {
                stack.pop();  // smaller building loses ocean view
            }
            stack.push(i);  // current building potentially has ocean view
        }

        // Stack contains indices in increasing order directly (no need to sort)
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        OceanViewLeftToRight solution = new OceanViewLeftToRight();

        int[] heights1 = {4, 2, 3, 1};
        int[] heights2 = {4, 3, 2, 1};
        int[] heights3 = {1, 3, 2, 4};

        System.out.println(Arrays.toString(solution.findBuildings(heights1)));  // [0,2,3]
        System.out.println(Arrays.toString(solution.findBuildings(heights2)));  // [0,1,2,3]
        System.out.println(Arrays.toString(solution.findBuildings(heights3)));  // [3]
    }
}


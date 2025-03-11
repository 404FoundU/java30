package DSA.Stack.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

//https://www.youtube.com/watch?v=_ZEvmycwXHs
class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();

        // Example 1
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures1)));
        // Output: [1,1,4,2,1,1,0,0]

        // Example 2
        int[] temperatures2 = {30, 40, 50, 60};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures2)));
        // Output: [1,1,1,0]

        // Example 3
        int[] temperatures3 = {30, 60, 90};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures3)));
        // Output: [1,1,0]
    }
}

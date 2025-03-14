package DSA.Stack.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

//https://www.youtube.com/watch?v=_ZEvmycwXHs
class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] nextGreaterTemp = new int[temperatures.length];
        Arrays.fill(nextGreaterTemp, 0); // no required as int default is 0
        Stack<Integer> stack = new Stack<>();

        //monotonic decreasing
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer previousDay = stack.pop();
                // next greater temp is at temperatures[i] which is ith position
                // calculate the numbere of days
                nextGreaterTemp[previousDay] = i - previousDay;
            }
            stack.push(i);
        }
        return nextGreaterTemp;
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

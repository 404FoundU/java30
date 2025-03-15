package DSA.Stack.MonotonicStack;

import java.util.Stack;

//https://www.youtube.com/watch?v=UMFKP9cTDtI
class TrappingRainWater {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                Integer top = stack.pop(); // reference the popped value as top. Bottom bar index
                if (stack.isEmpty()) break; // no left boundary
                int currentStackTopIndex = stack.peek();
                // distance between left & right boundaries
                // currentIndex - currentStackTop - 1
                //we're counting the number of bars BETWEEN these boundaries, not including the bars themselves. so -1
                int w = i - currentStackTopIndex - 1;
                // Min of height[currentIndex], height[currentStackTop] - top
                int h = Math.min(height[currentStackTopIndex], height[i]) - height[top];
                total += w * h;
            }
            stack.push(i);
        }
        return total;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();

        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height2 = {4, 2, 0, 3, 2, 5};

        System.out.println(solution.trap(height1)); // Output: 6
        System.out.println(solution.trap(height2)); // Output: 9
    }
}


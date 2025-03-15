package DSA.Stack.MonotonicStack;

import java.util.Stack;

class TrappingRainWater {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int waterTrapped = 0;

        for (int i = 0; i < height.length; i++) {
            // While current bar height is greater than stack top bar height
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop(); // bottom bar index

                if (stack.isEmpty()) break; // no left boundary

                int leftBoundary = stack.peek(); // left boundary index
                int width = i - leftBoundary - 1; // distance between left & right boundaries
                int boundedHeight = Math.min(height[leftBoundary], height[i]) - height[bottom];

                waterTrapped += width * boundedHeight;
            }
            stack.push(i);
        }
        return waterTrapped;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();

        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height2 = {4, 2, 0, 3, 2, 5};

        System.out.println(solution.trap(height1)); // Output: 6
        System.out.println(solution.trap(height2)); // Output: 9
    }
}


package DSA.RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=CsDI-yQuGeM&list=PLKYEe2WisBTEY7eJBW7W-jbxlXCGb928P&index=8
import java.util.ArrayList;
import java.util.List;

public class JumpGame2 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 1, 4};
        System.out.println(jumpgame(arr));  // Output: 2
    }

    static int result = Integer.MAX_VALUE;

    private static int jumpgame(int[] arr) {
        // Initialize result to a very high value (for tracking the minimum number of jumps)
        result = Integer.MAX_VALUE;

        // Start backtracking from index 0
        backtrack(arr, 0, 0);
        return result;
    }

    // Backtracking function: arr = input array, start = current index, jumps = number of moves taken
    private static void backtrack(int[] arr, int start, int jumps) {
        // Base case: if we've reached the last index
        if (start >= arr.length - 1) {
            result = Math.min(result, jumps);
            return;
        }
        // Explore all possible jumps from the current index
        for (int j = 1; j <= arr[start]; j++) {
            if (start + j < arr.length) {
                // Recurse to the next position after taking the jump
                backtrack(arr, start + j, jumps + 1);
            }
        }
    }
}


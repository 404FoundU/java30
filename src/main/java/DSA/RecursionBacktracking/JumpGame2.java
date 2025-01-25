package DSA.RecursionBacktracking;

public class JumpGame2 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 1, 4};
        System.out.println(jumpgame(arr));  // Output: 2
        System.out.println(jumpgameoptimized(arr)); // Expected output: 2

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
        for (int i = 1; i <= arr[start]; i++) {
            int begin = start + i;
            if (begin < arr.length) {
                // Recurse to the next position after taking the jump
                backtrack(arr, begin, jumps + 1);
            }
        }
    }

    private static int jumpgameoptimized(int[] nums) {
        if (nums.length == 1) {
            return 0; // If we're already at the end, no jumps are needed.
        }

        int jumps = 0;         // Number of jumps needed to reach the end.
        int currentEnd = 0;    // The furthest point we can reach with the current number of jumps.
        int furthest = 0;      // The furthest point we can reach with the next jump.

        for (int i = 0; i < nums.length - 1; i++) {
            furthest = Math.max(furthest, i + nums[i]); // Update the furthest we can reach.

            // If we reach the end of the range for the current jump:
            if (i == currentEnd) {
                jumps++;            // Increase the jump count.
                currentEnd = furthest; // Update the current end to the furthest we can reach.

                // If we can already reach or surpass the last index, we are done.
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}






package DSA.Patterns.Probablility;

import java.util.Random;

class RandomPickIndex {
    private int[] nums;
    private Random rand;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    public int pick(int target) {
        int count = 0; // Count occurrences of target
        int result = -1; // To store the randomly picked index

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                // Reservoir Sampling: Pick the current index with probability 1/count
                if (rand.nextInt(count) == 0) {
                    result = i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3}; // Example input
        RandomPickIndex obj = new RandomPickIndex(nums);

        // Picking index of 3 multiple times to see randomness
        System.out.println(obj.pick(3)); // Should return 2, 3, or 4 randomly
        System.out.println(obj.pick(3));
        System.out.println(obj.pick(3));
        System.out.println(obj.pick(1)); // Should return 0
    }
}

package DSA.Patterns.Probablility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//https://www.youtube.com/watch?v=paCJBO-yi9Q
//https://leetcode.com/problems/random-pick-index/
// reservoir sampling
class RandomPickIndex {
    private int[] nums;
    private Random rand;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    public int pick(int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, new ArrayList<>());
        }
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            int value = nums[i];
            map.get(value).add(i);
        }
        if (!map.containsKey(target)) {
            return -1; // Handle case where target is not in nums
        }
        List<Integer> values = map.get(target);
        int randomIndex = rand.nextInt(0, values.size());
        return values.get(randomIndex);
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

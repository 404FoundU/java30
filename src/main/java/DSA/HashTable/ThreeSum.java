package DSA.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=54VcLqAHrHk
public class ThreeSum {

    public static List<List<Integer>> threeSumBF(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicate i

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicate j

                for (int k = j + 1; k < n; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue; // skip duplicate k

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSumBF(nums);
        System.out.println("Triplets: " + result);
        //Triplets: [[-1, -1, 2], [-1, 0, 1]]
    }
}

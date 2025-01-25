package DSA.Patterns.TwoPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//https://leetcode.com/problems/top-k-frequent-elements/description/
//https://www.youtube.com/watch?v=phNDYf1xzco
public class BucketSort {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            Integer count = frequencyMap.getOrDefault(num, 0);
            frequencyMap.put(num, count + 1);
        }


        // initialize the bucket
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            buckets.add(new ArrayList<>());
        }
        // The index represents frequency, and each bucket contains a list of numbers

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int index = entry.getValue();
            buckets.get(index).add(entry.getKey());
        }
        // Step 3: Collect the top k=2 frequent elements

        List<Integer> result = new ArrayList<>();
        for (int i = buckets.size() - 1; i >= 0 && result.size() < k; i--) {
            if (!buckets.get(i).isEmpty()) {
                List<Integer> numbers = buckets.get(i);
                result.addAll(numbers);
            }

        }


        return result;

    }

    public static void main(String[] args) {
        BucketSort solution = new BucketSort();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        List<Integer> topK = solution.topKFrequent(nums, k);
        System.out.println("Top K Frequent Elements: " + topK);
    }
}

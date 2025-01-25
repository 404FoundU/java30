package DSA.Patterns.Heaps;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-elements/description/
public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> topK = solution.topKFrequent(nums, k);
        for (int num : topK) {
            System.out.print(num + " ");
        }


    }

    private List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int num : nums) {
            Integer value = counter.getOrDefault(num, 0);
            counter.put(num, value + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue()
        );

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            result.add(entry.getKey());
        }
        return result;

    }


}

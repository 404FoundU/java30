package DSA.Patterns.Heaps;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-elements/description/
public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        KClosestPointsToOrigin solution = new KClosestPointsToOrigin();
        int[][] nums = {
                {3, 3},
                {5, -1},
                {-2, 4}
        };
        int k = 2;
        List<List<Integer>> topK = solution.KClosestPoints(nums, k);
        System.out.print(topK);


    }

    private List<List<Integer>> KClosestPoints(int[][] nums, int k) {

        Map<Map<Integer, Integer>, Integer> originDistance = new HashMap<>();
        for (int[] numPairs : nums) {
            Map<Integer, Integer> point = new HashMap<>();
            Integer x = numPairs[0];
            Integer y = numPairs[1];
            point.put(x, y);
            int dist = (int) Math.sqrt((x * x) + (y * y));
            originDistance.put(point, dist);
        }
        PriorityQueue<Map.Entry<Map<Integer, Integer>, Integer>> pq = new PriorityQueue<>(
                (a, b) -> (int) (b.getValue() - a.getValue())
        );

        for (Map.Entry<Map<Integer, Integer>, Integer> entry : originDistance.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            Map.Entry<Map<Integer, Integer>, Integer> entry = pq.poll();
            Map<Integer, Integer> points = entry.getKey();
            for (Map.Entry<Integer, Integer> point : points.entrySet()) {
                List<Integer> p = new ArrayList<>();
                p.add(point.getKey());
                p.add(point.getValue());
                result.add(p);
            }
        }
        return result;

    }


}

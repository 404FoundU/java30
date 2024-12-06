package DSA.Patterns.Heaps;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-elements/description/
public class KClosestPointsToOriginArray {
    public static void main(String[] args) {
        KClosestPointsToOriginArray solution = new KClosestPointsToOriginArray();
        int[][] nums = {
                {3, 3},
                {5, -1},
                {-2, 4}
        };
        int k = 2;
        int[][] topK = solution.KClosestPoints(nums, k);
        for (int[] numPairs : topK) {

            System.out.print(Arrays.toString(numPairs));

        }
    }

    private int[][] KClosestPoints(int[][] nums, int k) {


        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (distanceSquared(o2) == distanceSquared(o1)) {
                    return 0;
                }
                if (distanceSquared(o2) > distanceSquared(o1)) {
                    return 1;
                }

                return -1;
            }
        }
        );
        for (int[] numPairs : nums) {
            maxHeap.add(numPairs);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] result = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            int[] point = maxHeap.poll();
            result[i++] = point;
        }
        return result;
    }

    public int distanceSquared(int[] p) {
        return (p[0] * p[0]) + (p[1] * p[1]);
    }

}

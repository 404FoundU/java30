package DSA.Patterns.Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        // Initialize a max-heap using PriorityQueue with reverse order comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the max-heap
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // Process the stones
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll(); // Heaviest stone
            int stone2 = maxHeap.poll(); // Second heaviest stone
            if (stone1 != stone2) {
                maxHeap.add(stone1 - stone2); // Add the difference back to the heap
            }
        }

        // Return the last remaining stone or 0 if none
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        LastStoneWeight solution = new LastStoneWeight();
        int[] stones = {2, 7, 4, 1, 8, 1};
        int result = solution.lastStoneWeight(stones);
        System.out.println("Last stone weight: " + result); // Output: 1
    }
}


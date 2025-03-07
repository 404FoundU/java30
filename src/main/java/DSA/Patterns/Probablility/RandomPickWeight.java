package DSA.Patterns.Probablility;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class RandomPickWeight {
    private int[] cumulativeSum;
    private int totalWeight;
    private Random random;

    public RandomPickWeight(int[] w) {
        random = new Random();
        int total = 0;
        cumulativeSum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            cumulativeSum[i] = total;
        }
        totalWeight = total;
    }

    public int pickIndex() {
        int indexRange = random.nextInt(totalWeight); // Fix: Use valid nextInt() method
        return binarySearch(indexRange);
    }

    private int binarySearch(int target) {
        int l = 0, r = cumulativeSum.length - 1; // Fix: Prevent out-of-bounds access
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (cumulativeSum[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] weights = {1, 3, 5, 2}; // Example weights
        RandomPickWeight solution = new RandomPickWeight(weights);

        // Running multiple trials to observe frequency distribution
        int trials = 10;
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < trials; i++) {
            int index = solution.pickIndex();
            frequency.put(index, frequency.getOrDefault(index, 0) + 1);
        }

        // Printing selection frequencies
        System.out.println("Index selection frequencies: " + frequency);
    }
}

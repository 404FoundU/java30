package DSA.Patterns.BinarySearchDAndC;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class RandomPickWeight {
    private int[] prefixSum;
    private int totalWeight;
    private Random random;

    public RandomPickWeight(int[] w) {
        prefixSum = new int[w.length];
        totalWeight = 0;
        random = new Random();

        for (int i = 0; i < w.length; i++) {
            totalWeight += w[i];
            prefixSum[i] = totalWeight;
        }
    }

    public int pickIndex() {
        int rand = random.nextInt(totalWeight);
        return binarySearch(rand);
    }

    private int binarySearch(int target) {
        int left = 0, right = prefixSum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSum[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public class Main {
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

}

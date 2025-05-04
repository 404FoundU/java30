package DSA.Patterns.BinarySearchDAndC;


//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
public class ShipWithinDays {
    public static void main(String[] args) {
        // Test cases
        int[] weights1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days1 = 5; // Expected output: 15

        int[] weights2 = {3, 2, 2, 4, 1, 4};
        int days2 = 3; // Expected output: 6

        int[] weights3 = {1, 2, 3, 1, 1};
        int days3 = 4; // Expected output: 3

        System.out.println("Minimum capacity: " + shipWithinDays(weights1, days1));
        System.out.println("Minimum capacity: " + shipWithinDays(weights2, days2));
        System.out.println("Minimum capacity: " + shipWithinDays(weights3, days3));
    }

    /*
    l = 10
    r = 55
     */
    public static int shipWithinDays(int[] weights, int days) {
        int l = getMax(weights); // min weight
        int r = getSum(weights); // total weight could be shipped in 1 day

        while (l < r) {
            int m = l + (r - l) / 2;
            if (canShip(weights, m, days)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;

    }

    // Helper method to check if a given capacity can ship all packages within days
    /*
    d = 0
    totalWeight = 0
   capacity = 35
     */
    static boolean canShip(int[] weights, int capacity, int days) {
        int d = 1;
        int totalWeight = 0;

        for (int w : weights) {
            totalWeight += w;
            if (totalWeight > capacity) {
                totalWeight = w;
                d++;
            }
        }
        if (d <= days) {
            return true;
        }
        return false;
    }

    // Helper method to get the maximum weight in the array
    private static int getMax(int[] weights) {
        int max = 0;
        for (int weight : weights) {
            max = Math.max(max, weight);
        }
        return max;
    }

    // Helper method to get the sum of all weights in the array
    private static int getSum(int[] weights) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }
}


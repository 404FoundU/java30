package DSA.Patterns.DivideAndConquer;

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

    public static int shipWithinDays(int[] weights, int days) {
        int left = getMax(weights); // Minimum capacity needed
        int right = getSum(weights); // Maximum capacity possible

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                right = mid; // Try a smaller capacity
            } else {
                left = mid + 1; // Increase the capacity
            }
        }

        return left; // The minimum capacity to ship within days
    }

    // Helper method to check if a given capacity can ship all packages within days
    private static boolean canShip(int[] weights, int days, int capacity) {
        int currentWeight = 0;
        int daysNeeded = 1;

        for (int weight : weights) {
            if (currentWeight + weight > capacity) {
                daysNeeded++;
                currentWeight = 0;
            }
            currentWeight += weight;

            if (daysNeeded > days) {
                return false;
            }
        }

        return true;
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


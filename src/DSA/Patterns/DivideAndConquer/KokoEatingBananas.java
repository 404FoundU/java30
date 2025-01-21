package DSA.Patterns.DivideAndConquer;

public class KokoEatingBananas {
    public static void main(String[] args) {
        // Test cases
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8; // Expected output: 4

        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5; // Expected output: 30

        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6; // Expected output: 23

        System.out.println("Minimum eating speed: " + minEatingSpeed(piles1, h1));
        System.out.println("Minimum eating speed: " + minEatingSpeed(piles2, h2));
        System.out.println("Minimum eating speed: " + minEatingSpeed(piles3, h3));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1; // Minimum speed
        int right = getMax(piles); // Maximum speed

        while (left < right) {
            int mid = left + (right - left) / 2; // Calculate mid-point

            if (canEat(piles, h, mid)) {
                right = mid; // Try a smaller speed
            } else {
                left = mid + 1; // Increase speed
            }
        }
        return left; // Minimum feasible speed
    }

    private static boolean canEat(int[] piles, int h, int capacity) {
        double hoursNeeded = 0;

        for (int pile : piles) {
            // Use Math.ceil to calculate the number of hours for each pile
            hoursNeeded += Math.ceil((double) pile / capacity);
            if (hoursNeeded > h) {
                return false; // Stop early if hours exceed the limit
            }
        }

        return hoursNeeded <= h;
    }


    private static int getMax(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
}



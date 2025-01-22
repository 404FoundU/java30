package DSA.Patterns.DivideAndConquer;

//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
public class MinimumDaysToMakeBouquets {
    public static void main(String[] args) {
        // Test cases
        int[] bloomDay1 = {1, 10, 3, 10, 2};// day it will bloom
        int m1 = 3, k1 = 1; // Expected output: 3

        int[] bloomDay2 = {1, 10, 3, 10, 2};
        int m2 = 3, k2 = 2; // Expected output: -1

        int[] bloomDay3 = {7, 7, 7, 7, 12, 7, 7};// need 3 flowers to be adjacent
        int m3 = 2, k3 = 3; // Expected output: 12

        System.out.println("Minimum days: " + minDays(bloomDay1, m1, k1));
        System.out.println("Minimum days: " + minDays(bloomDay2, m2, k2));
        System.out.println("Minimum days: " + minDays(bloomDay3, m3, k3));
    }

    private static int minDays(int[] bloomDay, int bouquets, int flowers) {
        if (bloomDay.length < flowers * bouquets) {
            return -1;
        }
        int left = getMin(bloomDay);
        int right = getMax(bloomDay);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMake(bloomDay, bouquets, flowers, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //determine if it's possible to make m bouquets in a given number of days.
    private static boolean canMake(int[] bloomDay, int bouquets, int flowers, int maxDays) {
        int flowersNeeded = 0;
        int bouquetNeeded = 0;
        for (int day : bloomDay) {
            if (day <= maxDays) {
                flowersNeeded++;
                if (flowersNeeded == flowers) {
                    bouquetNeeded++;
                    flowersNeeded = 0;
                }
            } else {
                flowersNeeded = 0;// Reset flowers if flower didnt bloom
            }
            if (bouquetNeeded >= bouquets) {
                return true;
            }

        }

        return false;
    }

    private static int getMax(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    private static int getMin(int[] nums) {
        int min = 0;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }
}

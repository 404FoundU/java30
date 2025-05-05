package DSA.Patterns.BinarySearchDAndC;

//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
public class MinimumDaysToMakeBouquets2 {
    public static void main(String[] args) {
        // Test cases
        int[] bloomDay1 = {1, 10, 3, 10, 2};// day it will bloom
        int m1 = 3, k1 = 1; // Expected output: 3

        int[] bloomDay2 = {1, 10, 3, 10, 2};
        int m2 = 3, k2 = 2; // Expected output: -1

        int[] bloomDay3 = {7, 7, 7, 7, 12, 7, 7};// need 3 flowers to be adjacent
        int m3 = 2, k3 = 3; // Expected output: 12

//        System.out.println("Minimum days: " + minDaysBF(bloomDay1, m1, k1));
//        System.out.println("Minimum days: " + minDays(bloomDay1, m1, k1));
//        System.out.println("Minimum days: " + minDaysBF(bloomDay2, m2, k2));
//        System.out.println("Minimum days: " + minDays(bloomDay2, m2, k2));
        System.out.println("Minimum days: " + minDaysBF(bloomDay3, m3, k3));
//        System.out.println("Minimum days: " + minDays(bloomDay3, m3, k3));
    }

    private static int minDaysBF(int[] bloomDay, int bouquets, int flowers) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int day : bloomDay) {
            max = Math.max(day, max);
            min = Math.min(day, min);
        }
        int days = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) {
            int b = 0;
            int currentFlowers = 0;

            for (int day : bloomDay) {
                if (day <= i) {
                    currentFlowers++;
                    if (currentFlowers == flowers) {
                        b++;
                        currentFlowers = 0;
                    }
                } else {
                    currentFlowers = 0; // reset flowers
                }
            }
            if (b >= bouquets) {
                days = Math.min(days, i);
            }

        }
        if (days == Integer.MAX_VALUE) {
            return -1;
        }
        return days;

    }

    //determine if it's possible to make m bouquets in a given number of days.
    private static boolean canMake(int[] bloomDay, int bouquets, int flowers, int maxDays) {
        int flowersNeeded = 0;
        int bouquetNeeded = 0;
        for (int day : bloomDay) {
            if (day > maxDays) {
                flowersNeeded = 0;// Reset flowers since we need continuous days
            } else {
                flowersNeeded++;
                if (flowersNeeded == flowers) {
                    bouquetNeeded++;
                    flowersNeeded = 0;
                }
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


}

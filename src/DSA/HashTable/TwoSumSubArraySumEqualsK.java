package DSA.HashTable;


import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=AmlVSNBHzJg

/*
Say you are given an array e.g. [a0, a1, a2, a3, a4, a5, a6... an] .

[a0,  a1,  a2,    a3,   a4,   a5,  a6, ... an]
	        ^	                   ^
             sumI	                sumJ


sumI = sum of numbers till a2 (a0 + a1 + a2)
sumJ = sum of numbers till a5 (a0 + a1 + a2 + a3 + a4 + a5)


Now lets say the difference between sumJ and sumI is equal to k.
What that means is, the sum of numbers between a2 and a5 is equal to k ( a3 + a4 + a5 = k ), which means we found a subarray whose sum is equal to k.

We can write a3 + a4 + a5 = k as sumJ - sumI = k and sumJ - sumI = k can be written as sumJ - k = sumI

The expression sumJ - k = sumI, means have we already seen a sum which is equal to sum at current index j minus k. If yes, it means we found a subarray whose sum is equal to k.
 */
public class TwoSumSubArraySumEqualsK {


    public static void main(String[] args) {
        TwoSumSubArraySumEqualsK test = new TwoSumSubArraySumEqualsK();

        int[] ints = {1, 1, 1};
        int target = 2;
        System.out.println(test.testMethod(ints, target));

    }

    private int testMethod(int[] num, int target) {
        Map<Integer, Integer> sumTimes = new HashMap<>();
        int currentSum = 0;
        int count = 0;
        // we have seen a sum of zero once
        sumTimes.put(currentSum, 1);
        // have we seen the target - currentSum before
        for (int i = 0; i < num.length; i++) {
            currentSum = currentSum + num[i];
            int sumI = currentSum - target;
            if (sumTimes.containsKey(sumI)) {
                count = count + sumTimes.get(sumI);
            }
            sumTimes.put(currentSum, sumTimes.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}

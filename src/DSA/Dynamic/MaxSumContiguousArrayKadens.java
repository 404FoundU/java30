package DSA.Dynamic;

//https://www.youtube.com/watch?v=hLPkqd60-28
public class MaxSumContiguousArrayKadens {
    public static void main(String[] args) {
        MaxSumContiguousArrayKadens test = new MaxSumContiguousArrayKadens();
        int[] nums = {-2, -3, 4, -1, -2, 1, 5, -3};
        int sum = test.testMethod(nums);
        System.out.println("sum = " + sum);
        int sum2 = test.bruteforce(nums);
        System.out.println("sum2 = " + sum2);

    }

    private int testMethod(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }

        }
        return maxSum;

    }

    private int bruteforce(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }

        }
        return maxSum;

    }


}

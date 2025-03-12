package DSA.Dynamic;

//https://www.youtube.com/watch?v=hLPkqd60-28
// bottom up
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
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE; // can have negative values

        for (int num : nums) {
            currSum += num;
            maxSum = Math.max(currSum, maxSum);
            // having a negative integer is not gonna help us. so reset it
            if (currSum < 0) {
                currSum = 0;
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

    /*
    Steps: calculate max sum at each level
    i=0
    -2
    -2  -3
    -2  -3 + 4
    -2  -3 + 4  -1
    -2  -3 + 4  -1 -2
    -2  -3 + 4  -1 -2 + 1
    -2  -3 + 4  -1 -2 + 1 + 5
    -2  -3 + 4  -1 -2 + 1 + 5 - 3
    i=1
    -3
    -3 + 4
    -3 + 4  -1
    -3 + 4  -1 -2
    -3 + 4  -1 -2 + 1
    -3 + 4  -1 -2 + 1 + 5
    -3 + 4  -1 -2 + 1 + 5 - 3
     */


}

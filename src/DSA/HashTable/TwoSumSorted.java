package DSA.HashTable;


import java.util.Arrays;

public class TwoSumSorted {


    public static void main(String[] args) {
        TwoSumSorted test = new TwoSumSorted();

        int[] ints = {2, 7, 11, 15};
//        int[] ints = {3,3};
        int sum = 18;
        System.out.println(Arrays.toString(test.testMethod(ints, sum)));

    }

    private int[] testMethod(int[] num, int target) {
        int left = 0;
        int right = num.length - 1;
        while (left < right) {
            int sum = num[left] + num[right];
            if (sum == target) {
                return new int[]{left, right};
            }
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{};


    }

}

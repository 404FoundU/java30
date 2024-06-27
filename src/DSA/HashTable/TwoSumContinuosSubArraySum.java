package DSA.HashTable;


import java.util.Arrays;

//https://www.youtube.com/watch?v=AmlVSNBHzJg
public class TwoSumContinuosSubArraySum {


    public static void main(String[] args) {
        TwoSumContinuosSubArraySum test = new TwoSumContinuosSubArraySum();

        int[] ints = {1, 2, 3, 4, 5};
        int target = 9;
        System.out.println(Arrays.toString(test.testMethod(ints, target)));

    }

    private int[] testMethod(int[] num, int target) {
        HashTable<Integer, Integer> cumulativeSumIndex = new HashTable<>();
        int currentSum = 0;
        cumulativeSumIndex.put(currentSum, -1);
        for (int i = 0; i < num.length; i++) {
            currentSum = currentSum + num[i];
            int compliment = currentSum - target;
            if (cumulativeSumIndex.get(compliment) != null) {
                return new int[]{cumulativeSumIndex.get(compliment) + 1, i};
            } else {
                cumulativeSumIndex.put(currentSum, i);
            }
        }
        return new int[]{};


    }

}

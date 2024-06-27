package DSA.HashTable;


import java.util.Arrays;

public class TwoSum {


    public static void main(String[] args) {
        TwoSum test = new TwoSum();

        int[] ints = {2, 7, 11, 15};
//        int[] ints = {3,3};
        int sum = 9;
        System.out.println(Arrays.toString(test.testMethod(ints, sum)));

    }

    private int[] testMethod(int[] num, int sum) {
        HashTable<Integer, Integer> hs = new HashTable<>();
        for (int i = 0; i < num.length; i++) {
            int key = num[i];
            int compliment = sum - key;
            if (hs.get(compliment) != null) {
                return new int[]{hs.get(compliment), i};
            } else {
                hs.put(key, i);
            }
        }
        return new int[0];


    }

}

package DSA.Arrays;


import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        ReverseArray test = new ReverseArray();
        int[] intArr = new int[] {1, 2, 3, 4, 5};

//        test.testMethod(intArr);
        test.swap(intArr, 0, intArr.length-1);
    }

    private void testMethod(int[] intArr) {
        int[] reverseArr = new int[intArr.length];
        int start = 0;
        for (int i = intArr.length -1; i >= 0; i--) {
            reverseArr[start] = intArr[i];
            start++;
        }
        System.out.println(Arrays.toString(reverseArr));

    }
    private void swap(int[] intArr, int start, int end) {
        while (start < end) {
            int temp = intArr[start];
            intArr[start] = intArr[end];
            intArr[end] = temp;
            start++;
            end--;
        }

        System.out.println(Arrays.toString(intArr));

    }




}

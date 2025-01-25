package DSA.Arrays;


import java.util.Arrays;

public class MoveZeroesToEndArray {
    public static void main(String[] args) {
        MoveZeroesToEndArray test = new MoveZeroesToEndArray();
        int[] intArr = new int[] {0,1, 0,6, 3,0, 4, 5};//{1,6,3,4,5,0,0,0}

//        test.testMethod(intArr);
        test.twoPointerSwap(intArr);


    }

    private void twoPointerSwap(int[] a) {
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0 && a[j] == 0) {
                swap(a, i, j);
            }

            if (a[j] != 0) {
                j++;
            }
        }

        System.out.println(Arrays.toString(a));

    }


    private void swap(int[] a, int start, int end) {
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }
    private void testMethod(int[] a) {

        int[] b = new int[a.length];
        int start = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] !=0 ) {
                b[start] = a[i];
                start++;
            }
        }


        while (start < a.length - 1) {
            b[start] = 0;
            start++;
        }

            System.out.println(Arrays.toString(b));


    }



}

package DSA.Patterns.TwoPointer;


import java.util.Arrays;

//https://youtu.be/gcRUIO-8r3U?t=1838&si=zcs1N0HGEUCkxvjV
public class CountingSort { // O(n+k)
    public static void main(String[] args) {
        CountingSort test = new CountingSort();
        int[] arr = {5, 3, 2, 1, 3, 3, 7, 2, 2}; // positive array preferred
        test.testMethod(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void testMethod(int[] arr) {
        int max = 0;
        for (int n : arr) {
            max = Math.max(n, max);
        }
        int[] c = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            c[num]++;
        }
        System.out.println(Arrays.toString(c));
        int j = 0;
        for (int i = 0; i < c.length; i++) {
            while (c[i] > 0) {
                arr[j] = i;
                j++;
                c[i]--;
            }
        }

    }


}

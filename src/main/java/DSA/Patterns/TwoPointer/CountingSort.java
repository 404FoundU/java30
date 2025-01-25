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
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int[] counts = new int[max + 1];// new array with max indices
        Arrays.fill(counts, 0);
        for (int i = 0; i < arr.length; i++) {
            int elem = arr[i];
            counts[elem] = counts[elem] + 1;
        }
//        System.out.println("counts = " + Arrays.toString(counts));
        int i = 0;
        for (int c = 0; c < counts.length; c++) {
            while (counts[c] > 0) {
                arr[i++] = c;
                counts[c] = counts[c] - 1;
            }

        }
    }


}

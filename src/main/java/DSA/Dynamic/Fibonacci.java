package DSA.Dynamic;


import java.util.Arrays;

public class Fibonacci {


    private static long[] memo ;


    public static void main(String[] args) {
        Fibonacci test = new Fibonacci();
        int n = 6;
        memo = new long[n+1];
//        System.out.println(test.fibonacciNum(n));
//        System.out.println(test.fibonacciNumArray(6));
        System.out.println(test.fibonacciNoMemory(6));

    }

    private long fibonacciNum(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        long nthFibNumber = fibonacciNum(n - 1) + fibonacciNum(n - 2);
        memo[n] = nthFibNumber;
        return nthFibNumber;

    }

  /*  private long fibonacciTabulation(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];

        }
        return arr[n];
    }*/


    // Bottom up (Tabulation )
    private long fibonacciTabulation2(int n) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 0);
        arr[1] = 1;
        for (int i = 0; i <= n; i++) {
            arr[i + 1] += arr[i];
            arr[i + 2] += arr[i];
        }
        return arr[n];
    }

    // Bottom up ( No memory )
    // store previous 2 values only
    private long fibonacciNoMemory(int n) {
        if (n < 2) {
            return n;
        }
        int previous = 0;
        int current = 1;
        for (int i = 2; i < n + 1; i++) {
            int temp = current;
            current += previous;
            previous = temp;

        }
        return current;
    }


}

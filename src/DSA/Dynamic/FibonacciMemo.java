package DSA.Dynamic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciMemo {


    private static long[] memo ;


    public static void main(String[] args) {
        FibonacciMemo test = new FibonacciMemo();
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

    // Bottom up (Tabulation )
    private long fibonacciNumArray(int n) {
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1));
        for (int i = 2; i < n + 1; i++) {
            Integer newElem = list.get(i - 2) + list.get(i - 1);
            list.add(newElem);
        }
        return list.get(n);
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

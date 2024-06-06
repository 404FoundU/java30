package DSA.Dynamic;


public class FibonacciMemo {


    private static long[] memo ;


    public static void main(String[] args) {
        FibonacciMemo test = new FibonacciMemo();
        int n = 6;
        memo = new long[n+1];
        System.out.println(test.fibonacciNum(n));
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


}

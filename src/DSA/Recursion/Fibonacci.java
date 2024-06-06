package DSA.Recursion;


public class Fibonacci {



    public static void main(String[] args) {
        Fibonacci test = new Fibonacci();
        System.out.println(test.fibonacciNum(6));
    }

    private long fibonacciNum(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciNum(n-1) + fibonacciNum(n-2);

    }


}

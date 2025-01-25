package DSA.RecursionBacktracking;


//Recursive backtracking
//https://www.youtube.com/watch?v=wRH2I6IN4BE&list=PLxQ8cCJ6LyObv8vjQD443c-1JEqlhCCXe&index=2
public class Fibonacci {



    public static void main(String[] args) {
        Fibonacci test = new Fibonacci();
        System.out.println(test.fibonacciNum(6));
    }


    //O(2^n) exponential, On
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

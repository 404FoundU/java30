package DSA.RecursionBacktracking;


public class GreatestCommonDivisor {
    public static void main(String[] args) {
        GreatestCommonDivisor test = new GreatestCommonDivisor();
        int result = test.testMethod(48, 18);//2
        System.out.println("result = " + result);
    }

    /*
    Euclidian algorithm
             48/18 = 2 , 12
             18/12 =1, 6
             12/6 = 2, 0
             6/0 =
48 % 0 ==             */
    private int testMethod(int m, int n) {
        if (n == 0) {
            return m;
        }
        int reminder = m % n;
        if (reminder == 0) {
            return m / n;
        }
        return testMethod(n, reminder);
    }

}

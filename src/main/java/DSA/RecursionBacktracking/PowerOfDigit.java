package DSA.RecursionBacktracking;


public class PowerOfDigit {
    public static void main(String[] args) {
        PowerOfDigit test = new PowerOfDigit();
        int power = test.testMethod(5, 3);//125
        System.out.println("power = " + power);
    }

    /*
              5,5
           5*5^4=5*5^3=5*5^2=5 *5^1

             */
    private int testMethod(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        return base * testMethod(base, exponent - 1);
    }


}

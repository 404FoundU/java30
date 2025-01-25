package DSA.RecursionBacktracking;


public class SumOfDigits {
    public static void main(String[] args) {
        SumOfDigits test = new SumOfDigits();
        int sum = test.testMethod(5432);//14
        System.out.println("sum = " + sum);
    }

    /*
             5432/10 = 543 5432%10 =2
             543/10 = 54     543%10 = 3
             54/10=5         54%10 = 4
             5/10 = 0        5%10 = 5
             */
    private int testMethod(int num) {
        if (num == 0) {
            return num;
        }
        int quotient = num / 10; //543
        int reminder = num % 10; // 2
        return reminder + testMethod(quotient);


    }


}

package DSA.RecursionBacktracking;


public class DecimalToBinary {
    public static void main(String[] args) {
        DecimalToBinary test = new DecimalToBinary();
        String result = test.testMethod(15);//1 1 1 1
        System.out.println("result = " + result);
        int result2 = test.testMethod2(15);//1 1 1 1
        System.out.println("result2 = " + result2);
    }

    /*
    15/2 =7, 1
    7/2=3, 1
    3/2=1, 1
    1/2=0, 1

            */
    private String testMethod(int dec) {

        int quotient = dec / 2;

        int reminder = dec % 2;
        if (quotient == 0) {
            return String.valueOf(reminder);
        }
        return String.valueOf(reminder) + testMethod(quotient);
    }

    private int testMethod2(int dec) {

        int quotient = dec / 2;

        int reminder = dec % 2;
        if (quotient == 0) {
            return reminder;
        }
        int value = 10 * testMethod2(quotient);
        return reminder + value;
    }

}


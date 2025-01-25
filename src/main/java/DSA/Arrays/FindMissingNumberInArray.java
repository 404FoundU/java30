package DSA.Arrays;


import java.util.Arrays;

public class FindMissingNumberInArray {
    public static void main(String[] args) {
        FindMissingNumberInArray test = new FindMissingNumberInArray();
        int[] intArr = new int[] {1, 3, 4, 5};

        test.testMethod(intArr);

    }

    private void testMethod(int[] intArr) {
        int lastNumber = intArr.length+1;
        int sumOfNumbers = lastNumber * (lastNumber + 1) / 2;
        int arraySum = Arrays.stream(intArr).sum() ;
        System.out.println("missing :"+ (sumOfNumbers-arraySum));

    }



}

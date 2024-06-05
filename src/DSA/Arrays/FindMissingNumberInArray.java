package DSA.Arrays;


public class FindMissingNumberInArray {
    public static void main(String[] args) {
        FindMissingNumberInArray test = new FindMissingNumberInArray();
        int[] intArr = new int[] {1, 3, 4, 5};

        test.testMethod(intArr);

    }

    private void testMethod(int[] intArr) {

        int max = intArr[0];
        for (int i = 1; i <intArr.length ; i++) {
            if (intArr[i] > max) {
                max = intArr[i];
            }
        }
        System.out.println(max);

        int secondMax = intArr[0] ;
        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] > secondMax && intArr[i] < max) {
                secondMax = intArr[i];
            }
        }
        System.out.println(secondMax);

    }



}

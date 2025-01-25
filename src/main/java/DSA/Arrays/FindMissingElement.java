package DSA.Arrays;


public class FindMissingElement {
    public static void main(String[] args) {
        FindMissingElement test = new FindMissingElement();
        int[] intArr = new int[] {1, 7,6, 3,8, 4, 5};//2
//        int[] intArr = new int[] {1,2,3,5};//4

//        test.testMethod(intArr);

        test.sumOfNum(intArr);


    }

    private void sumOfNum(int[] a) {
        int n = a.length + 1;
        int sum = (n * (n + 1)) / 2;
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            total = total + a[i];
        }
        System.out.println(sum - total);
    }
    private void testMethod(int[] a) {

        int total = a.length;
        int[] b = new int[total];

        for (int i = 1; i <= total ; i++) {
            boolean exists = false;
            for (int j = 0; j < total; j++) {
                if (a[j] == i) {
                    exists =true;
                }

            }
            if (exists == false) {
                System.out.println(i);
            }
        }





    }



}

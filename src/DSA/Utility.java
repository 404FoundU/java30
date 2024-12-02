package DSA;


import java.util.Arrays;
import java.util.Random;

public class Utility {
    public static void main(String[] args) {

    }

    public static void SwapArrayIndexes(int[] numArray, int i, int j) {
        int temp = numArray[i];
        numArray[i] = numArray[j];
        numArray[j] = temp;
    }

    public static int[] getRandomArray() {
        Random random = new Random();
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }
        System.out.println("random Array " + Arrays.toString(numbers));
        return numbers;
    }


}

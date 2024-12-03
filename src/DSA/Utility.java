package DSA;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Utility {
    public static void main(String[] args) {

    }

    public static void swapArrayIndexes(int[] numArray, int i, int j) {
        int temp = numArray[i];
        numArray[i] = numArray[j];
        numArray[j] = temp;
    }

    public static int[] getRandomArray() {
        Random random = new Random();
        int[] numbers = new int[9];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }
        System.out.println("random Array " + Arrays.toString(numbers));
        return numbers;
    }

    public static int[] integerListToArray(List<Integer> list) {
        int[] array = new int[list.size()];
        int index = 0;
        for (Integer e : list) {
            array[index++] = e;
        }
        return array;
    }
}

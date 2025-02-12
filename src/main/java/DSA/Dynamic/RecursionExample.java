package DSA.Dynamic;

import java.util.Arrays;

public class RecursionExample {
    public static void main(String[] args) {
        RecursionExample re = new RecursionExample();
        int[] array = {1, 2, 3, 4, 5}; // Example input
        re.foo(array);
    }

    private void foo(int[] array) {
        StringBuilder str = new StringBuilder();

        int midIdx = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, midIdx);
        int[] right = Arrays.copyOfRange(array, midIdx, array.length);

        foo(left);
        foo(right);
    }
}

/*
Recursion Tree Visualization for an Example Input {1, 2, 3, 4, 5}:

           12345
          /     \
       12       345
      /  \      /   \
     1    2    3    45
                  /    \
                 4      5

depth is log n
width at level 1 is 1
width at level 2 is 2
width at level 3 is 4
width:  n
total = n log(n)
*/

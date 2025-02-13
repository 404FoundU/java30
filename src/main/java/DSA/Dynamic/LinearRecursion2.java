package DSA.Dynamic;

import java.util.Arrays;

public class LinearRecursion2 {
    public static void main(String[] args) {
        LinearRecursion2 re = new LinearRecursion2();
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
 at level 1  - we do not do any extra work in each level like a for loop
 at level 2 we do 2 recursive calls. double the nodes but input is halved. and do not do any extra work
 so O(n) is width
total = n * log n


depth is O(log n).
2 new arrays are created left and right. The total size of the array is O(n)
space = n + log(n) = n
*/

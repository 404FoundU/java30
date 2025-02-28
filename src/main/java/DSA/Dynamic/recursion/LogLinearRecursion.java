package DSA.Dynamic.recursion;

import java.util.Arrays;

public class LogLinearRecursion {
    public static void main(String[] args) {
        LogLinearRecursion re = new LogLinearRecursion();
        int[] array = {1, 2, 3, 4, 5}; // Example input
        re.foo(array);
    }

    private void foo(int[] array) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            str.append(i);
        }
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

depth is log n - Divide the input by half
width: The tree has fixed growth of O(n) in width.
 at level 1  - we do  extra work in each level like a for loop - 5 iteration
 at level 2 we do 2 recursive calls and also do extra work - 2 iteration + 3 iteration = 5
so O(n)

total = n * log n

depth is O(log n).
total size of newly created array remains O(n)

space = n log(n)
*/

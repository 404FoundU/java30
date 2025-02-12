package DSA.Dynamic;


public class FactorialRecursion {
    public static void main(String[] args) {
        foo(5);
    }

    private static void foo(int n) {
        if (n == 1) return;

        for (int i = 0; i < n; i++) {
            foo(n - 1);
        }
    }
}
    /*
    Recursion Tree for foo(5):

        foo(5)
        ├── foo(4) // 5 * foo(4)
        │   ├── foo(3) // 5 * 4 * foo(3)
        │   │   ├── foo(2) // 5 * 4 * 3 * foo(2)
        │   │   │   ├── foo(1)  (terminates) // 5 * 4 * 3 * 2 * foo(1)
        │   │   │   ├── foo(1)  (terminates)
        │   │   │
        │   │   ├── foo(2)
        │   │   │   ├── foo(1)  (terminates)
        │   │   │   ├── foo(1)  (terminates)
        │   │   │
        │   │   ├── foo(2)
        │   │       ├── foo(1)  (terminates)
        │   │       ├── foo(1)  (terminates)
        │   │
        │   ├── foo(3)  (same structure as above)
        │   ├── foo(3)  (same structure as above)
        │   ├── foo(3)  (same structure as above)
        │
        ├── foo(4)  (same structure as above)
        ├── foo(4)  (same structure as above)
        ├── foo(4)  (same structure as above)
        ├── foo(4)  (same structure as above)

    Time Complexity: O(n!)
    depth: n
    width at level 1 is 1
    width at level 2 is 5
    width at level 3 is 5 * 4 - there are four 3's under one 5
    width at level 4 is 5 * 4 * 3
    width at level 5 is 5 * 4 * 3 * 2

    Space Complexity: O(n) (due to recursion stack)
    */



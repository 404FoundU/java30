package DSA.Dynamic.recursion;

public class QuadraticRecursion {
    public static void countPairs(int n, int i) {
        if (i >= n) return; // Base case

        // Loop runs (n - i) times
        for (int j = i + 1; j < n; j++) {
            System.out.println("(" + i + ", " + j + ")");
        }

        // Recursive call
        countPairs(n, i + 1);
    }

    public static void main(String[] args) {
        int n = 4;
        countPairs(n, 0);
    }
}
/*
countPairs(4, 0)
│   ├── Prints: (0,1), (0,2), (0,3)
│   ├── Calls → countPairs(4, 1)
│
├── countPairs(4, 1)
│   ├── Prints: (1,2), (1,3)
│   ├── Calls → countPairs(4, 2)
│
├── countPairs(4, 2)
│   ├── Prints: (2,3)
│   ├── Calls → countPairs(4, 3) [Base Case, returns]
│
└── countPairs(4, 3) → Base Case, returns

countPairs(4, 0)
├── (0,1)
├── (0,2)
├── (0,3)
└── countPairs(4, 1)
    ├── (1,2)
    ├── (1,3)
    └── countPairs(4, 2)
        ├── (2,3)
        └── countPairs(4, 3) (Base Case, returns)

depth is n
width n-1 work
level 1 - 4 branch n
level 2 - 3 branch n-1
level 3 - 2 branch n-1 -1

n* n-1
 */

package DSA.Dynamic;

import java.util.HashMap;
import java.util.Map;

// given the size m * n of a grid. Travel from 0,0 to m-1,n-1.
// How many ways can you travel
public class GridTravellerMemo {

    private static Map<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {

//        System.out.println(gridTraveller(1, 1)); //1
        System.out.println(gridTraveller(2, 3)); //3

        System.out.println(gridTraveller(3, 2)); // 3
        System.out.println(gridTraveller(3, 3)); // 6
        System.out.println(gridTraveller(18, 18));
    }

    private static int gridTraveller(int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        String key = m + "," + n;
        if (memo.get(key) != null) {
            return memo.get(key);
        }
        int pathSum = gridTraveller(m - 1, n) + gridTraveller(m, n - 1); // down + right
        memo.put(key, pathSum);

        return memo.get(key);
    }
}
    /*
            (2,3)
          /       \
   (1,3)            (2,2)
   /    \           /     \
(0,3)  (1,2)       (1,2)   (2,1)
      /    \      /   \    /   \
   (0,2) (1,1) (0,2)(1,1)(1,1) (0,0)

-with memo O(m+n)

space:
depth is m+n
2 new matrix are created but the total size is still O(m+n)
so m+n
    * */



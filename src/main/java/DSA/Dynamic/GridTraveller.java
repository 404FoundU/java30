package DSA.Dynamic;

// given the size m * n of a grid. Travel from 0,0 to m-1,n-1.
// How many ways can you travel
public class GridTraveller {
    public static void main(String[] args) {

        System.out.println(gridTraveller(1, 1)); //1
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
        return gridTraveller(m - 1, n) + gridTraveller(m, n - 1);
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

- initial (2,3)
* travel down will reduce grid size to m-1, n = (1,3)
* travel right will reduce grid size to m, n-1 = (2,2)
* (1,1) is the base case
* (0,3) means there are no rows

    * */



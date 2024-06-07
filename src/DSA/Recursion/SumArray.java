package DSA.Recursion;


public class SumArray {



    public static void main(String[] args) {
        SumArray test = new SumArray();
        int x = test.sumArr(new int[]{1,5,7,-2});
        int y = test.sumArr2(new int[]{1,5,7,-2});
        System.out.println(x);
        System.out.println(y);
    }


    // O(n^2) and O(n)
    private int sumArr(int[] n) {
        if (n.length == 0) {
            return 0;
        }
        int[] rest = new int[n.length - 1];
        System.arraycopy(n,1, rest,0, n.length -1);
        return n[0] + sumArr(rest);
    }

   //O(n)
    private int sumArr2(int[] n) {
        return _sumArr2(n, 0);
    }

    private int _sumArr2(int[] n, int start) {
        if (n.length == start) {
            return 0;
        }
        return n[start] + _sumArr2(n, start + 1);
    }

}

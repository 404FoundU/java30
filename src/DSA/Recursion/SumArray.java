package DSA.Recursion;


public class SumArray {



    public static void main(String[] args) {
        SumArray test = new SumArray();
        long x = test.sumArr(new int[]{1,5,7,-2});
        System.out.println(x);
    }

    private long sumArr(int[] n) {
        if (n.length == 0) {
            return 0;
        }
        int[] rest = new int[n.length - 1];
        System.arraycopy(n,1, rest,0, n.length -1);
        return n[0] + sumArr(rest);    }


}

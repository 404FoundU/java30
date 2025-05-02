package DSA.Bit;

/*
   a = 4 ⊕ 1 ⊕ 2 ⊕ 1 ⊕ 2
       = (1⊕1) ⊕ (2⊕2) ⊕ 4
       =    0   ⊕   0   ⊕ 4
       = 4

 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int result = 0;

        for (int number : nums) {
            result ^= number;  // XOR all numbers
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}));       // Output: 1
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2})); // Output: 4
        System.out.println(singleNumber(new int[]{1}));             // Output: 1
    }
}


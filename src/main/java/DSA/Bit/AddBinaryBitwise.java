package DSA.Bit;

public class AddBinaryBitwise {

    public static String addBinary(String a, String b) {
        // Convert binary strings to integers
        int numA = Integer.parseInt(a, 2);
        int numB = Integer.parseInt(b, 2);

        // Bitwise addition
        while (numB != 0) {
            int withoutCarry = numA ^ numB;       // XOR gives the sum without carry
            int carry = (numA & numB) << 1;       // AND then left shift gives the carry
            numA = withoutCarry;
            numB = carry;
        }

        // Convert result back to binary string
        return Integer.toBinaryString(numA);
    }

    //Brute force
    /*
    Start from the rightmost digits (least significant).

Add corresponding bits and carry.

Store result and move to the next bits on the left.

⚙️ Steps:
Use two pointers to iterate from end of both strings.

Add digits and keep track of carry.

Append result from the back and finally reverse the result.
     */
    public static String addBinaryBF(String a, String b) {
        StringBuilder result = new StringBuilder();

        int pointerA = a.length() - 1;
        int pointerB = b.length() - 1;
        int carry = 0;

        while (pointerA >= 0 || pointerB >= 0 || carry == 1) {
            int bitA = pointerA >= 0 ? a.charAt(pointerA) - '0' : 0;
            int bitB = pointerB >= 0 ? b.charAt(pointerB) - '0' : 0;

            int sum = bitA + bitB + carry;

            // Append the current bit (0 or 1)
            result.append(sum % 2);

            // Update carry
            carry = sum / 2;

            pointerA--;
            pointerB--;
        }

        // Result is in reverse order
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));      // Output: 100
        System.out.println(addBinary("1010", "1011")); // Output: 10101
        System.out.println(addBinary("0", "0"));       // Output: 0
        System.out.println(addBinary("1", "111"));     // Output: 1000
    }
}


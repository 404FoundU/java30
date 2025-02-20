package DSA.Arrays.Strings;

public class GetExpressionString {

    static String getExpressionString(String exp) {


        char[] charArray = exp.toCharArray();
        StringBuilder result = new StringBuilder();
        result.append("BigDecimal result = ");
        int counter = 0;

        for (char c : charArray) {
            if (Character.isLetterOrDigit(c)) {
                result.append("BigDecimal.valueOf(").append(c).append(")");
            } else if (c == '+') {
                result.append(".add(");
                counter++;
            } else if (c == '-') {
                result.append(".subtract(");
                counter++;
            } else if (c == '*') {
                result.append(".multiply(");
                counter++;
            } else if (c == '/') {
                result.append(".divide(");
                counter++;
            } else if (c == '(' || c == ')') {
                result.append(c);
            } else if (c == ' ') {
                continue;
            }
        }

        while (counter > 0) {
            result.append(")");
            counter--;
        }

        result.append(";");
        return result.toString();
    }

    public static void main(String[] args) {


        System.out.println(getExpressionString("x+(y/z)+400-x)"));
        // x + (y / z) + 400 - x
        //"BigDecimal result = BigDecimal.valueOf(x).add((BigDecimal.valueOf(y).
        //divide(BigDecimal.valueOf(z))).add(BigDecimal.valueOf(400)).subtract
        //(BigDecimal.valueOf(x)));"
    }


}




package Snippets.Functional;


import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryLambda {


    UnaryOperator<String> uo = (name) -> name.toUpperCase();
    BinaryOperator<Integer> bo = (a, b) -> a * b;

    Comparator<Integer> comp = (a, b) -> a.compareTo(b);
    BinaryOperator<Integer> bo2 = BinaryOperator.maxBy(comp);

    public static void main(String[] args) {
        UnaryLambda test = new UnaryLambda();
        test.testMethod();
    }

    private void testMethod() {
        System.out.println(uo.apply("Unni"));
        System.out.println(bo.apply(3,2));
        System.out.println("Result of max:" + bo2.apply(4,5));

    }


}

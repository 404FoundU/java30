package Snippets.Functional;


import java.util.Comparator;

public class ComparatorLambda {
    public static void main(String[] args) {
        ComparatorLambda test = new ComparatorLambda();
        test.testMethod();
    }

    private void testMethod() {
        Comparator<Integer> comparatorLambda = (a, b) -> a.compareTo(b);
        System.out.println(comparatorLambda.compare(2, 3));

    }


}

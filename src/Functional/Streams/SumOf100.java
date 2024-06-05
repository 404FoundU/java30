package Functional.Streams;


import java.util.stream.IntStream;

public class SumOf100 {
    public static void main(String[] args) {
        SumOf100 test = new SumOf100();
        test.testMethod();
        Object[] objects = new Object[1];

    }

    private void testMethod() {
        int sum = IntStream.rangeClosed(0, 100)
                .parallel()
                .sum();


    }


}

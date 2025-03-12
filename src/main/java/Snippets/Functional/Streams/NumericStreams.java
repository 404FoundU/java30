package Snippets.Functional.Streams;


import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreams {



    public static void main(String[] args) {
        NumericStreams test = new NumericStreams();
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        test.sumOfNumbers(nums);
    }

    private void sumOfNumbers(List<Integer> nums) {
        Integer sum = nums.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        int intSum = IntStream.rangeClosed(1, 7)
                .sum();
        long count = IntStream.rangeClosed(1, 7)
                .count();
        OptionalInt max = IntStream.rangeClosed(1, 7)
                .max();
        System.out.println(max.isPresent()? max.getAsInt():0);
        System.out.println(intSum);

        //autobox
        List<Integer> integerList = IntStream.rangeClosed(1, 7)
                .boxed()
                .collect(Collectors.toList());
        //unbox
        int streamSum = nums.stream()
                .mapToInt(i -> i.intValue())
                .sum();

        List<Integer> integerList1 = IntStream.rangeClosed(1, 7)
                .mapToObj(i -> new Integer(i))
                .collect(Collectors.toList());

        Integer sum3 = Stream.of(10, 20, 30, 40)
                .reduce(0, (a, b) -> a + b);
        int sum4 = IntStream.rangeClosed(0, 100)
                .parallel()
                .sum();

    }


}

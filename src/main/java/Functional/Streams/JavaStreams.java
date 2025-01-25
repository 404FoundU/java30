package Functional.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args) {

        //Integer Stream - 10 is not included
        IntStream
                .range(1,10)
                .skip(5)
                .forEach(System.out::print);// println can be called using ::.
        System.out.println();
        IntStream
                .range(1,10)
                .skip(5)
                .forEach(x -> System.out.println(x)); // lambda can be replaced wit method reference like 12 line

        //Integer stream with sum
        System.out.println(
                IntStream
                        .range(1, 5)
                        .sum()
        );
        System.out.println();
        // Stream.of sorted and findFirst
        Stream.of("U","N","N","I")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
        // Stream from array, sort, filter
//        String[] names = new String[] {"U", "N", "N", "I"};
        String[] names = {"U", "N", "N", "I"};
        Arrays.stream(names)  // Stream.of(names)
                .sorted()
                .filter(x -> x.startsWith("N"))
                .forEach(System.out::print);
        System.out.println();
        //Average of the squares of int array
//        int[] num = new int[]{2, 4, 6, 8}; // array literal
        int[] num ={2, 4, 6, 8};
        Arrays.stream(num)
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);

        //For primitives arrays (like int[], long[] etc), Arrays.stream() and Stream.of() have different return types..
        // Stream.of() method returns Stream whereas Arrays.stream() returns an IntStream.
        Stream<int[]> stream1 = Stream.of(num);
        //flatten the array
        IntStream intStreamNew = stream1.flatMapToInt(Arrays::stream);
        intStreamNew
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);
        System.out.println();
        // stream from list filter and print
        List<String> people = Arrays.asList("U", "N", "N", "I", "K", "n");
        people
                .stream()
                .map(x -> x.toLowerCase())
                .filter(x->x.startsWith("n"))
                .forEach(System.out::println);

        // Stream file
       /* *
       Stream<String> bands = Files.lines(Paths.get("bands.txt"));
        bands
                .sorted()
                .filter(x -> x.contains("U")
                .collect(Collectors.toList());
                bands.forEach(System.out::println);
        bands.close();*/
        System.out.println();

        // Reduce
        double total = Stream.of(8.9, 7.0, 5.4)
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println(total);

        List<Integer> data= Arrays.asList(12, 13, 56, 790);
        long Temp = data.stream()
                .reduce(Integer::sum)
                .get();
        Stream.<String>builder().add("Unni").add("Rishi").build();


    }

}

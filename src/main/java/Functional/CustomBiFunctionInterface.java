package Functional;


import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class CustomBiFunctionInterface {
    public static void main(String[] args) {
        // Using BiFunction for addition
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> subtract = (a, b) -> a - b;
        // Applying the BiFunctions
        System.out.println("Addition: " + add.apply(10, 5));         // 15
        System.out.println("Subtraction: " + subtract.apply(10, 5)); // 5


        List<int[]> numberPairs = Arrays.asList(
                new int[]{10, 5},
                new int[]{20, 4},
                new int[]{15, 3}
        );
        List<Integer> results = numberPairs.stream()
                .map(pair -> add.apply(pair[0], pair[1])) // Apply the BiFunction to each pair
                .collect(Collectors.toList());
    }
}

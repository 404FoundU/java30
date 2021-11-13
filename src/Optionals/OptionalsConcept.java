package Optionals;

import java.util.Arrays;
import java.util.Optional;

public class OptionalsConcept {
    private static String email;
    //https://www.youtube.com/watch?v=rreENe7TdvI

    public static Optional<Integer> findElement(Integer[] arr, int x) {
        return Arrays.stream(arr)
                .filter(num -> num == x)
                .findFirst();
    }

    //If return value may be null use isNullable
    static Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
    //
    // person.getEmail().map(String::toLowerCase).orElse("No email");

    public static void main(String[] args) {

        //Optional is a container object
        // contains item or empty
        //get() to retrieve value
        Optional<Integer> numExists = Optional.of(5);
        Optional<Integer> numDoesnotExists = Optional.empty();
        if (numExists.isPresent()) {
            System.out.println(numExists.get());
        }
        if (numDoesnotExists.isPresent()) {
            System.out.println(numDoesnotExists.get());
        }
        numExists.ifPresent(x -> System.out.println(x));
        numDoesnotExists.ifPresent(System.out::println);

        findElement(new Integer[]{1,2,3},3).ifPresent(System.out::println);
        findElement(new Integer[]{1,2,3},3).ifPresentOrElse(
                x-> System.out.println(x),
                ()-> System.out.println("not present"));



    }


}

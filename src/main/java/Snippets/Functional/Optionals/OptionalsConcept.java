package Optionals;

import Snippets.Functional.data.Student;

import java.util.Arrays;
import java.util.Optional;

public class OptionalsConcept {
    private static String email;

    //https://www.youtube.com/watch?v=rreENe7TdvI
    public static Optional<Integer> findElement2(Integer[] arr, int x) {
        for (Integer n : arr) {
            if (arr[n] == x) {
//                return x;
                return Optional.of(x);
            }
        }
//        return null;
        return Optional.empty();
    }

    public static Optional<Integer> findElement(Integer[] arr, int x) {
        return Arrays.stream(arr)
                .filter(n -> n == x)
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
        Optional<Integer> numExists = Optional.of(5); //declare
        Optional<Integer> numDoesnotExists = Optional.empty();
        if (numExists.isPresent()) {
            System.out.println("num" + numExists);
            System.out.println("num" + numExists.get());//retrieve
        }
        if (numDoesnotExists.isPresent()) {
            System.out.println(numDoesnotExists.get());
        }
        numExists.ifPresent(x -> System.out.println(x));
        numDoesnotExists.ifPresent(System.out::println);

        findElement(new Integer[]{1, 2, 3}, 3).ifPresent(System.out::println);
        findElement(new Integer[]{1, 2, 3}, 3).ifPresentOrElse(
                x -> System.out.println(x),
                () -> System.out.println("not present"));


        //orElse
        /*Course maxCourse = courses.stream()
                .max(compareByNoOfStudentsAndReviews)
                .orElse((new Course("Kubernetes", "Cloud", 91, 20000)));
        System.out.println(maxCourse);*/


        Student student = new Student(null, 2, 3.6, "male", Arrays.asList("swimming", "basketball", "volleyball"));
        String nameRaw = student.getName();
        //try catch NPE hides other errors
        // we expect a null value. Hence use ofNullable
        Optional<String> username = Optional.ofNullable(nameRaw);

        username.ifPresentOrElse(
                val -> System.out.println("Hello, " + val),
                () -> System.out.println("Guest")
        );


        Optional<String> opt1 = Optional.of("Unni");
        Optional<String> opt2 = Optional.empty();

        // Using get()
        System.out.println(opt1.get()); // ✅ Prints: Unni
        // System.out.println(opt2.get()); ❌ Throws NoSuchElementException

        // Using orElse()
        System.out.println(opt1.orElse("Default")); // ✅ Unni
        System.out.println(opt2.orElse("Default")); // ✅ Default

        opt1.ifPresentOrElse(
                value -> System.out.println("Hello, " + value),
                () -> System.out.println("Name not found")
        );
    }


}

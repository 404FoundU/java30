package Functional;


import Functional.data.Student;
import Functional.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionLambda {


    static Function<String, String> f = (name) -> name.toUpperCase();
    static Function<String, String> f2 = (name) -> name.concat("pillai ");

    static Function<List<Student>, Map<String,Double>> sf = students -> {
        Map<String, Double> map = new HashMap();
        students.forEach(student -> {
            map.put(student.getName(),student.getGpa());
        });
        return map;
    };

    public static void main(String[] args) {
        FunctionLambda test = new FunctionLambda();
        test.testMethod();


        Function<String, String> identityFunction = Function.identity();
        String result = identityFunction.apply("Hello");
        System.out.println(result); // Output: Hello
        /*
        The identity() method returns a function that simply returns its input.
        Input "Hello" is returned as "Hello" without any modification.
         */

        // The identity() method is used here as the key mapper, meaning the key in the resulting map is the element itself.
        Stream<String> stream = Stream.of("apple", "banana", "cherry");
        System.out.println(
                stream.collect(Collectors.toMap(Function.identity(), String::length))
        );
        System.out.println(
                stream.collect(Collectors.toMap(s -> s, String::length))
        );
        // Output: {apple=5, banana=6, cherry=6}


    }

    private void testMethod() {
        System.out.println(f.andThen(f2).apply("unni"));
        System.out.println(f.compose(f2).apply("unni"));
        List<Student> students = StudentDataBase.getAllStudents();
        System.out.println(sf.apply(students));;

    }


}

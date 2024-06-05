package Functional;


import Functional.data.Student;
import Functional.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionLambda {


    static Function<String, String> f = (name) -> name.toUpperCase();
    static Function<String, String> f2 = (name) -> name.toLowerCase().concat("pillai ");

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
    }

    private void testMethod() {
        System.out.println(f.andThen(f2).apply("unni"));
        System.out.println(f.compose(f2).apply("unni"));
        List<Student> students = StudentDataBase.getAllStudents();
        System.out.println(sf.apply(students));;

    }


}

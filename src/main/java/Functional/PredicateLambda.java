package Functional;


import Functional.data.Student;
import Functional.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateLambda {


    static Predicate<Integer> p = i -> i % 2 == 0;
    static Predicate<Integer> p2 = i -> i % 5 == 0;

    static Predicate<Student> p3 = s -> s.getGradeLevel() > 3;
    public static void main(String[] args) {
        PredicateLambda test = new PredicateLambda();
        test.testMethod();
    }

    private void testMethod() {
        System.out.println(p.test(2));
        System.out.println(p.and(p2).test(10));
        System.out.println(p.or(p2).test(8));
        System.out.println(p.or(p2).negate().test(8));

        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach((student)->{
            if (p3.test(student)) {
                System.out.println(student);
            }
        });

    }


}

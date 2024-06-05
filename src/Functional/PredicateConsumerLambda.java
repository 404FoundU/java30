package Functional;


import Functional.data.Student;
import Functional.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateConsumerLambda {




    static Predicate<Student> p1 = s -> s.getGradeLevel() >= 3;
    static Predicate<Student> p2 = s -> s.getGpa() >= 3.9;

    BiConsumer<String, List<String>> bc = (name, activity) -> System.out.println(name + " " + activity);

    Consumer<Student> c = student -> {
        if (p1.and(p2).test(student)) {
            bc.accept(student.getName(), student.getActivities());
        }
    };

    public static void main(String[] args) {
        PredicateConsumerLambda test = new PredicateConsumerLambda();
        test.testMethod();
    }

    private void testMethod() {


        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(c);
    }


}

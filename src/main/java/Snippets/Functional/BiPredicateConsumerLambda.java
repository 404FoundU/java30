package Snippets.Functional;


import Snippets.Functional.data.Student;
import Snippets.Functional.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class BiPredicateConsumerLambda {


    static BiPredicate<Integer, Double> p1 = (grade, gpa) -> grade >= 3 && gpa >= 3.9;

    BiConsumer<String, List<String>> bc = (name, activity) -> System.out.println(name + " " + activity);

    Consumer<Student> c = student -> {
        if (p1.test(student.getGradeLevel(), student.getGpa())) {
            bc.accept(student.getName(), student.getActivities());
        }
    };

    public static void main(String[] args) {
        BiPredicateConsumerLambda test = new BiPredicateConsumerLambda();
        test.testMethod();
    }

    private void testMethod() {


        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(c);
    }


}

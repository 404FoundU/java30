package Functional.Streams;


import Functional.data.Student;
import Functional.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Streams1 {
    public static void main(String[] args) {
        Streams1 test = new Streams1();
        test.testMethod();
    }

    private void testMethod() {
        List<Student> students = StudentDataBase.getAllStudents();


        Function<Student, String> f1 = student -> student.getName();
        Function<Student, List<String>> f2 = student -> student.getActivities();
        Predicate<Student> p1 = student -> student.getGradeLevel() >= 3;

        Map<String, List<String>> sMap = students.parallelStream()
                .filter(p1)
                .collect(Collectors.toMap(f1, f2));
        System.out.println(sMap);


    }


}

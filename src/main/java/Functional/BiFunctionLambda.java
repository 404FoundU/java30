package Functional;


import Functional.data.Student;
import Functional.data.StudentDataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionLambda {


    Predicate<Student> p = (student) -> student.getGradeLevel() > 3;
    static BiFunction<List<Student>, Predicate<Student>, Map<String,Double>> sf = (students,predicate) -> {
        Map<String, Double> map = new HashMap();
        students.forEach(student -> {
            if (predicate.test(student)) {
                map.put(student.getName(),student.getGpa());

            }
        });
        return map;
    };

    public static void main(String[] args) {
        BiFunctionLambda test = new BiFunctionLambda();
        test.testMethod();
    }

    private void testMethod() {
        List<Student> students = StudentDataBase.getAllStudents();

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Integer test = 2;
        Integer i = new Integer(5);
        Integer test2 = Integer.valueOf(3);
        int test3 = test.intValue();
        List<Integer> list = new ArrayList<>();
        list.add(3);
        System.out.println(list);
        System.out.println(sf.apply(students, p));;

    }


}

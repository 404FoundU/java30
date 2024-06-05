package Functional;


import Functional.data.Student;
import Functional.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BiConsumerLambda {


    public static void nameAndActivities() {
        List<Student> students = StudentDataBase.getAllStudents();

        BiConsumer<String, List<String>> bc = (a,b)-> {
            System.out.println(a);
            System.out.println(b);
        };
        Consumer<Student> consumer = student -> {
            bc.accept(student.getName(), student.getActivities());
        };

        students.forEach(consumer);
    }
    public static void main(String[] args) {
        BiConsumerLambda test = new BiConsumerLambda();
//        test.testMethod();
        nameAndActivities();
    }

    private void testMethod() {
        BiConsumer<String, String> c = (a,b) -> System.out.println(a +" "+b);
        c.accept("unni", "pillai");
        BiConsumer<Integer, Integer> multiply = (a,b) -> System.out.println("Multiply "+ a*b);
        BiConsumer<Integer, Integer> divide = (a,b) -> System.out.println("Divide "+ a/b);

        multiply.andThen(divide).accept(10, 2);

    }


}

package Functional;


import Functional.data.Student;
import Functional.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerLambda {

    static Consumer<Student> cStudent = s -> System.out.println(s);
    static Consumer<Student> cName = s -> System.out.println(s.getName());
    static Consumer<Student> cActivities = s -> System.out.println(s.getActivities());

    public static void printList() {

        List<Student> allStudents = StudentDataBase.getAllStudents();
        allStudents.forEach(cStudent);
    }
    public static void printNameAndActivities() {

        List<Student> allStudents = StudentDataBase.getAllStudents();
        Consumer<Student> action = cName.andThen(cActivities);// consumer chaining
        allStudents.forEach(action);
    }

    public static void printNameAndActivitiesByGrade() {

        List<Student> allStudents = StudentDataBase.getAllStudents();
        Consumer<Student> studentConsumer1 = (student) -> {
            if (student.getGradeLevel() >= 3) {
                Consumer<Student> studentConsumer = cName.andThen(cActivities);
                studentConsumer.accept(student);
            }
        };
        allStudents.forEach(studentConsumer1); // consumer chaining
    }
    public static void main(String[] args) {
        ConsumerLambda test = new ConsumerLambda();
        test.testMethod();
//        printList();
//        printNameAndActivities();
//        printNameAndActivitiesByGrade();
    }

    private void testMethod() {
        Consumer<String> c = (a) -> System.out.println(a.toUpperCase());
        c.accept("unni");
    }


}

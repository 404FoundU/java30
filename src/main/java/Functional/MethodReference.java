package Functional;

import Functional.data.Greet;
import Functional.data.Person;
import Functional.data.Student;
import Functional.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class MethodReference {

    public static void main(String[] args) {

        List<Student> students = StudentDataBase.getAllStudents();
        Student student = StudentDataBase.getStudent();
        students.forEach(System.out::println);// Static method
        List<String> names = students.stream().map(Student::getName)//Instance method
                .collect(Collectors.toList());
        Greet greeter = new Greet();
        names.forEach(greeter::greet);
        Person person = new Person();
        names.forEach(person::setPerson);//Instance method
        names.forEach(student::setName);//Instance method
        names.stream().map(Person::new);//Constructor
        names.sort(String::compareTo);//Instance method of arbitrary object

    }
}

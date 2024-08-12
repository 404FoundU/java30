package Functional.Streams;


import Functional.data.Student;
import Functional.data.StudentComparator;
import Functional.data.StudentDataBase;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTerminalOp {



    public static void main(String[] args) {
        StreamTerminalOp test = new StreamTerminalOp();
        test.testMethod();
    }

    private void testMethod() {

        List<Student> allStudents = StudentDataBase.getAllStudents();
        String names = allStudents.stream()
                .map(Student::getName)
                .collect(Collectors.joining("_"));

        System.out.println(names);
        long studentCount = allStudents.stream()
                .collect(Collectors.counting());

        System.out.println(studentCount);

        List<String> sList = allStudents.stream()
                .collect(Collectors.mapping(s -> s.getName(), Collectors.toList()));

        System.out.println(sList);
        Map<String, List<Student>> genderMap = allStudents.stream()
                .collect(Collectors.groupingBy(s -> s.getGender()));

        System.out.println(genderMap);
        System.out.println(Runtime.getRuntime().availableProcessors());


        List<String> stList = allStudents.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        stList.sort(Comparator.naturalOrder());// reverse list
        stList.sort(Comparator.reverseOrder());
        Collections.sort(allStudents);
        StudentComparator comparator = new StudentComparator();
        allStudents.sort(comparator);
        Collections.sort(allStudents, comparator);




    }


}

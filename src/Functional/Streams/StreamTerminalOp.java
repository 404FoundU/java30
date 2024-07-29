package Functional.Streams;


import Functional.data.Student;
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

        String names = StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining("_"));

        System.out.println(names);
        long studentCount = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.counting());

        System.out.println(studentCount);

        List<String> sList = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.mapping(s -> s.getName(), Collectors.toList()));

        System.out.println(sList);
        Map<String, List<Student>> genderMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(s -> s.getGender()));

        System.out.println(genderMap);
        System.out.println(Runtime.getRuntime().availableProcessors());


        List<String> stList = StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        stList.sort(Comparator.naturalOrder());// reverse list
        stList.sort(Comparator.reverseOrder());
        Collections.sort(StudentDataBase.getAllStudents());


    }


}

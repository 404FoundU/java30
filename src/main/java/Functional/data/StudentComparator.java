package Functional.data;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getGradeLevel() == o2.getGradeLevel()) {
            return 0;
        }
        if (o1.getGradeLevel() > o2.getGradeLevel()) {
            return 1;
        }
        return -1;
    }
}

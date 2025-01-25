package DSA.Stack.Queue;

import Functional.data.Student;
import Functional.data.StudentDataBase;

import java.util.PriorityQueue;

public class PriorityQueueImpl {

    public static void main(String[] args) {

        PriorityQueue<Student> pq = new PriorityQueue<>();
        StudentDataBase.getAllStudents().forEach(pq::add);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());//pq.peek()
        }

    }
}

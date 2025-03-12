package DSA.Stack.Queue;

import Snippets.Functional.data.Student;
import Snippets.Functional.data.StudentDataBase;

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

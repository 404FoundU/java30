package DSA.Heap;

import java.util.PriorityQueue;

class Task implements Comparable<Task> {
    String name;
    int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task other) {
        return this.priority - other.priority;  // Lower number = higher priority
    }

    @Override
    public String toString() {
        return "Task{" + "name='" + name + "', priority=" + priority + "}";
    }
}

public class SimplePriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();

        taskQueue.add(new Task("Write Code", 2));
        taskQueue.add(new Task("Test Code", 3));
        taskQueue.add(new Task("Debug", 1));

        // Polling tasks based on priority (min priority comes first)
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
    }
}

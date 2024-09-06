package DSA.Stack.Queue;

import java.util.LinkedList;

public class QueueLinkedList {
    LinkedList<Integer> list;

    public QueueLinkedList() {
        list = new LinkedList<>();
        System.out.println("The Queue is successfully created");
    }

    // isEmpty


    //enQueue
    public void enQueue(int value) {
        list.add(list.size(), value);
        System.out.println("Successfully inserted " + value + " in the queue");
    }

    // deQueue
    public int deQueue() {
        int value = -1;
        if (list.isEmpty()) {
            System.out.println("The Queue is is Empty");
        } else {
            value = list.getFirst();
//      list.deletionOfNode(0);
            list.remove(0);
        }
        return value;
    }

    //peek
    public int peek() {
        if (list.isEmpty()) {
            System.out.println("The Queue is Empty");
            return -1;
        } else {
            return list.getFirst();
        }
    }


}

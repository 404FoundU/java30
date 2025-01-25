package HashMapDemo;

import java.util.PriorityQueue;

public class QueueDemo {
    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for (int i = 10; i > 0; i--) {
            queue.add(i);
        }


        // Queue (Front) 10987654321(Rear)
        //P! (Front)12345678910( Rear) - PQ will sort
        //Peeking -> obtain head of queue
        //Polling -> Remove the head

        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue.peek());
    }
}

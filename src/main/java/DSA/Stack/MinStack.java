package DSA.Stack;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    PriorityQueue<Integer> pq;
    Set<Integer> deletedIds;
    public MinStack() {
        stack = new Stack<>();
        pq = new PriorityQueue<>();
        deletedIds = new HashSet<>();
    }

    public void push(int val) {
        stack.push(val);
        pq.add(val);
    }

    public void pop() {
        cleanUpStack();
        Integer pop = stack.pop();
        deletedIds.add(pop);
    }

    public int top() {
        cleanUpStack();
        return stack.peek();
    }

    public int getMin() {
        cleanUpHeap();
        return pq.peek();
    }

    public void removeMin() {
        cleanUpHeap();
        if (!pq.isEmpty()) {
            int removedVal = pq.poll();
            deletedIds.add(removedVal);
        }
    }

    private void cleanUpStack() {
        while (!stack.isEmpty() && deletedIds.contains(stack.peek())) {
            stack.pop();
        }
    }

    private void cleanUpHeap() {
        while (!pq.isEmpty() && deletedIds.contains(pq.peek())) {
            pq.poll();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(5);
        minStack.push(2);
        minStack.push(1);
        minStack.push(4);

        System.out.println("Min: " + minStack.getMin()); // 1
        minStack.removeMin(); // removes 1
        System.out.println("Min after removeMin(): " + minStack.getMin()); // 2
        minStack.pop(); // removes 4
        System.out.println("Top: " + minStack.top()); // 1 (removed, should be 2)
        System.out.println("Min now: " + minStack.getMin()); // 2
    }
}


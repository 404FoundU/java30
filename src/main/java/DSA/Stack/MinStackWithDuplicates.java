package DSA.Stack;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinStackWithDuplicates {
    private static class Node {
        int val;
        int id; // unique id to sync between stack and heap

        Node(int val, int id) {
            this.val = val;
            this.id = id;
        }
    }

    MyStack<Node> stack;
    PriorityQueue<Node> minHeap;
    Set<Integer> deletedIds;
    int counter;

    public MinStackWithDuplicates() {
        stack = new MyStack<>();
        deletedIds = new HashSet<>();
        counter = 0;

        minHeap = new PriorityQueue<>((a, b) -> {
            if (a.val != b.val) return Integer.compare(a.val, b.val);
            return Integer.compare(a.id, b.id);
        });
    }

    public void push(int val) {
        Node node = new Node(val, counter++);
        stack.push(node);
        minHeap.offer(node);
    }

    public void pop() {
        cleanUpStack();
        if (!stack.isEmpty()) {
            Node node = stack.pop();
            deletedIds.add(node.id);
        }
    }

    public int top() {
        cleanUpStack();
        return stack.peek().val;
    }

    public int getMin() {
        cleanUpHeap();
        return minHeap.peek().val;
    }

    public void removeMin() {
        cleanUpHeap();
        if (!minHeap.isEmpty()) {
            Node min = minHeap.poll();
            deletedIds.add(min.id);
        }
    }

    private void cleanUpStack() {
        while (!stack.isEmpty() && deletedIds.contains(stack.peek().id)) {
            stack.pop();
        }
    }

    private void cleanUpHeap() {
        while (!minHeap.isEmpty() && deletedIds.contains(minHeap.peek().id)) {
            minHeap.poll();
        }
    }

    public static void main(String[] args) {
        MinStackWithDuplicates minStack = new MinStackWithDuplicates();
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


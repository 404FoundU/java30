package DSA.LinkedList;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=DAzEniVtkMQ&list=PLKYEe2WisBTF21RGRtZfGGolpHmca_d3N&index=8
class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList {
    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) {
            return null; // Handle edge case where head is null
        }
        RandomNode current = head;
        Map<RandomNode, RandomNode> map = new HashMap<>();
        while (current != null) {
            map.put(current, new RandomNode(current.val));
            current = current.next;
        }
        current = head; // reset current
        RandomNode newHead = map.get(current);
        while (current != null) {
            RandomNode nextNode = current.next;
            RandomNode randomNode = current.random;
            RandomNode newNode = map.get(current);
            newNode.next = map.get(nextNode);
            newNode.random = map.get(randomNode);
            current = current.next;
        }
        return newHead;
    }


    public static void printList(RandomNode head) {
        RandomNode current = head;
        while (current != null) {
            System.out.print("Node(" + current.val + ", Random: ");
            if (current.random != null) {
                System.out.print(current.random.val);
            } else {
                System.out.print("null");
            }
            System.out.print(") -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create a test linked list: 1 -> 2 -> 3 -> null
        // Random pointers: 1 -> 3, 2 -> 1, 3 -> 2
        RandomNode node1 = new RandomNode(1);
        RandomNode node2 = new RandomNode(2);
        RandomNode node3 = new RandomNode(3);

        node1.next = node2;
        node2.next = node3;

        node1.random = node3; // 1 -> 3
        node2.random = node1; // 2 -> 1
        node3.random = node2; // 3 -> 2

        System.out.println("Original list:");
        printList(node1);

        CopyRandomList solution = new CopyRandomList();
        RandomNode copiedHead = solution.copyRandomList(node1);

        System.out.println("Copied list:");
        printList(copiedHead);
    }


}


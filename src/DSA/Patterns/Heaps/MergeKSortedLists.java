package DSA.Patterns.Heaps;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-heap to store (value, list index)
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.val, b.val);
        });

        // Add the first node of each list to the heap
        for (ListNode list : lists) {
            if (list != null) {
                heap.add(list);
            }
        }

        // Dummy node to start the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!heap.isEmpty()) {
            // Extract the smallest node
            ListNode smallest = heap.poll();
            current.next = smallest;
            current = current.next;

            // Add the next node of the list to the heap
            if (smallest.next != null) {
                heap.add(smallest.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Create test cases
        ListNode[] lists = new ListNode[3];

        // List 1: 1 -> 4 -> 5
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        // List 2: 1 -> 3 -> 4
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        // List 3: 2 -> 6
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        // Merge all lists
        MergeKSortedLists solution = new MergeKSortedLists();
        ListNode mergedList = solution.mergeKLists(lists);

        // Print the result
        printList(mergedList);
    }

    // Helper method to print a linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}



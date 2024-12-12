package DSA.LinkedList;

import static DSA.LinkedList.ListNode.printList;


public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        // Initialize two pointers both starting at the head
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer by one
            fast = fast.next.next;    // Move fast pointer by two
        }

        // When fast reaches the end, slow will be at the middle
        return slow;
    }

    // Helper method to build a linked list from an array
    public static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int val : values) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        return dummy.next;
    }


    // Main method to test the function
    public static void main(String[] args) {
        MiddleOfLinkedList solution = new MiddleOfLinkedList();

        // Example 1:
        int[] values1 = {1, 2, 3, 4, 5};
        ListNode head1 = buildList(values1);
        System.out.print("Original List: ");
        printList(head1);
        ListNode middle1 = solution.middleNode(head1);
        System.out.print("Middle Node and onwards: ");
        printList(middle1);

        // Example 2:
        int[] values2 = {1, 2, 3, 4, 5, 6};
        ListNode head2 = buildList(values2);
        System.out.print("Original List: ");
        printList(head2);
        ListNode middle2 = solution.middleNode(head2);
        System.out.print("Middle Node and onwards: ");
        printList(middle2);
    }
}


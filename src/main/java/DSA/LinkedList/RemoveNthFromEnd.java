package DSA.LinkedList;

import static DSA.LinkedList.ListNode.printList;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        int indx = 1;
        while (indx <= n) {
            indx++;
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return slow;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd solution = new RemoveNthFromEnd();

        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);

        System.out.print("Original List: ");
        printList(head);

        // Reversing the linked list recursively
        ListNode newHead = solution.removeNthFromEnd(head, 3);

        System.out.print("Inserted List): ");
        printList(newHead);
    }
}

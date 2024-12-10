package DSA.LinkedList;

public class RemoveDuplicatesFromSortedList {

    // Definition for singly-linked list.

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; // Skip the duplicate node
            } else {
                current = current.next; // Move to the next distinct node
            }
        }
        return head;
    }

    // Helper method to print the linked list
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();

        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        System.out.print("Original List 1: ");
        solution.printList(head1);
        head1 = solution.deleteDuplicates(head1);
        System.out.print("Modified List 1: ");
        solution.printList(head1);

        // Example 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(3);
        System.out.print("Original List 2: ");
        solution.printList(head2);
        head2 = solution.deleteDuplicates(head2);
        System.out.print("Modified List 2: ");
        solution.printList(head2);
    }
}


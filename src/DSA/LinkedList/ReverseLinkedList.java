package DSA.LinkedList;

//https://www.youtube.com/watch?v=KRxeMng7fBU&list=PLKYEe2WisBTF21RGRtZfGGolpHmca_d3N&index=2
public class ReverseLinkedList {

    // Recursive method to reverse the linked list.
    public ListNode reverseListRecursive(ListNode head) {
        // Base case: if head is null or only one node, it's reversed
        if (head == null || head.next == null) {
            return head;
        }
        // Recursively reverse the rest of the list
        ListNode newHead = reverseListRecursive(head.next);
        // Adjust the pointers
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next; // Store next node
            current.next = prev;              // Reverse current node's pointer
            prev = current;                   // Move prev to current node
            current = nextTemp;               // Move to next node
        }
        return prev; // New head of the reversed list
    }
    // Helper function to print the linked list.
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();

        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        solution.printList(head);

        // Reversing the linked list recursively
        ListNode reversedHead = solution.reverseListRecursive(head);

        System.out.print("Reversed List (Recursive): ");
        solution.printList(reversedHead);
    }
}


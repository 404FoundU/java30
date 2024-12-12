package DSA.LinkedList;

import static DSA.LinkedList.ListNode.printList;

//https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/
public class GreatestCommonDivisor {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            ListNode temp = current.next;

            int val1 = current.val;
            int val2 = temp.val;
            int gcd = gcd(val1, val2);
            ListNode insertNode = new ListNode(gcd);
            insertNode.next = temp;
            current.next = insertNode;
            current = current.next.next;
        }
        return head;
    }

    private int gcd(int val1, int val2) {
        int gcd = 1;
        int minVal = Math.min(val1, val2);
        for (int i = 2; i <= minVal; i++) {
            if (val1 % i == 0 && i % val2 == 0) {
                if (i > gcd) {
                    gcd = i;
                }
            }
        }
        return gcd;
    }

    public static void main(String[] args) {
        GreatestCommonDivisor solution = new GreatestCommonDivisor();

        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);

        System.out.print("Original List: ");
        printList(head);

        // Reversing the linked list recursively
        ListNode newHead = solution.insertGreatestCommonDivisors(head);

        System.out.print("Inserted List): ");
        printList(newHead);
    }
}

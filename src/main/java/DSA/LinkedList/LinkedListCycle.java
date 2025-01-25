package DSA.LinkedList;

//https://www.youtube.com/watch?v=y-ckZ2hpC8Y&list=PLKYEe2WisBTF21RGRtZfGGolpHmca_d3N&index=4
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;

    }
}

package DSA.LinkedList;

import static Functional.ConsumerLambda.printList;

//https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-list/
public class SumOfLL {
    public static void main(String[] args) {
        // Creating first linked list: 1 -> 2 -> 3
        // (represents 123)
        Node num1 = new Node(1);
        num1.next = new Node(2);
        num1.next.next = new Node(3);

        // Creating second linked list: 9 -> 9 -> 9
        // (represents 999)
        Node num2 = new Node(9);
        num2.next = new Node(9);
        num2.next.next = new Node(9);

        Node sum = addTwoLists(num1, num2);
        printLL(sum);
    }

    private static void printLL(Node current) {
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println();
    }

    static Node addTwoLists(Node num1, Node num2) {

        num1 = reverse(num1);
        num2 = reverse(num2);
        Node head = null;
        Node result = null;


//        printLL(num1);
//        printLL(num2);

        double carry = 0;
        while (num1 != null || num2 != null) {
            double data1 = 0;
            double data2 = 0;
            if (num1 != null) {
                data1 = num1.data;
            }
            if (num2 != null) {
                data2 = num2.data;
            }

            double sum = data1 + data2 + carry;
            double reminder = sum % 10;
            carry = Math.floor(sum / 10);
            Node temp = new Node(reminder);
            if (head == null) {
                result = temp;
                head = result;
            } else {
                result.next = temp;
                result = result.next;
            }
            num1 = num1.next;
            num2 = num2.next;

        }

        if (carry != 0) {
            result.next = new Node(carry);
        }
        return reverse(head);
    }

    private static Node reverse(Node current) {
        Node previous = null;
        Node temp = null;


        while (current != null) {
            temp = current.next; // 2 -> 3
            current.next = previous; // 1 -> null
            previous = current; // 1 -> null
            current = temp; // 2-> 3

        }
        return previous;
    }

}

class Node {
    double data;
    Node next;

    Node(double data) {
        this.data = data;
        this.next = null;
    }
}

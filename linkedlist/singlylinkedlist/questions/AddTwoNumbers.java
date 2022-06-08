package linkedlist.singlylinkedlist.questions;

import linkedlist.singlylinkedlist.Node;

public class AddTwoNumbers {

    public Node sum(Node sllHead1, Node sllHead2) {
        // Reverse The List
        sllHead1 = new ReverseLinkedList().reverseApproach3(sllHead1);
        sllHead2 = new ReverseLinkedList().reverseApproach3(sllHead2);

        // Addition
        Node ans = addition(sllHead1, sllHead2);
        ans = new ReverseLinkedList().reverseApproach3(ans);
        return ans;
    }

    private Node addition(Node sllHead1, Node sllHead2) {
        int carry = 0;
        Node sumList = null;

        while (sllHead1 != null && sllHead2 != null) {
            int res = carry + sllHead1.data + sllHead2.data;
            int digit = res % 10;
            sumList = insertAtTail(sumList, digit);
            carry = res / 10;

            sllHead1 = sllHead1.nxt;
            sllHead2 = sllHead2.nxt;
        }

        while (sllHead1 != null) {
            int res = carry + sllHead1.data;
            int digit = res % 10;
            sumList = insertAtTail(sumList, digit);
            carry = res / 10;

            sllHead1 = sllHead1.nxt;
        }

        while (sllHead2 != null) {
            int res = carry + sllHead2.data;
            int digit = res % 10;
            sumList = insertAtTail(sumList, digit);
            carry = res / 10;

            sllHead1 = sllHead2.nxt;
        }

        while (carry != 0) {
            int res = carry;
            int digit = res % 10;
            sumList = insertAtTail(sumList, digit);
            carry = res / 10;
        }

        return sumList;
    }

    Node insertAtTail(Node head, int data) {

        if (head == null) {
            head = new Node(data);
            return head;
        }

        Node curr = head;
        Node newNode = new Node(data);
        while (curr.nxt != null) {
            curr = curr.nxt;
        }
        curr.nxt = newNode;
        return head;
    }
}

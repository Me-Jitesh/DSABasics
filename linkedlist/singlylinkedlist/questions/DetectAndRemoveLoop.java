package linkedlist.singlylinkedlist.questions;

import java.util.HashMap;

import linkedlist.singlylinkedlist.Node;

public class DetectAndRemoveLoop {

    public boolean detectLoop(Node head) {
        if (head == null) {
            return false;
        }

        HashMap<Node, Boolean> visted = new HashMap<>();
        Node temp = head;

        while (temp != null) {
            if (visted.getOrDefault(temp, false) == true) {
                System.out.println("Loop Present On Element " + temp.data);
                return true;
            }
            visted.put(temp, true);
            temp = temp.nxt;
        }
        return false;
    }

    public Node detectLoopOpti(Node head) {

        if (head == null) {
            System.err.println("List Empty Hai");
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (slow != null && fast != null) {
            fast = fast.nxt;
            if (fast != null) {
                fast = fast.nxt;
            }
            slow = slow.nxt;
            if (slow == fast) {
                System.out.println("Loop Present at  " + slow.data);
                return slow;
            }
        }
        System.err.println("Loop Mila Hi nahi");
        return null;
    }

    public Node findStartingNode(Node head) {
        if (head == null) {
            return null;
        }

        Node intersection = detectLoopOpti(head);
        Node slow = head;

        while (slow != intersection) {
            slow = slow.nxt;
            intersection = intersection.nxt;
        }
        System.out.println("Starting Node is : " + slow.data);
        return slow;
    }

    public void removeLoop(Node head) {
        if (head == null) {
            return;
        }

        Node startingOfLoop = findStartingNode(head);
        Node temp = startingOfLoop;
        while (temp.nxt != startingOfLoop) {
            temp = temp.nxt;
        }
        temp.nxt = null;
        System.out.println("Loop Removed...");
        detectLoopOpti(head);
    }
}
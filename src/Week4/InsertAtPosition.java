package Week4;

import java.util.*;

public class InsertAtPosition {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);

        if (position == 0) {
            node.next = head;
            head = node;         //new head
        } else {
            SinglyLinkedListNode p = head;
            while (--position != 0) {
                p = p.next;
            }
            node.next = p.next;
            p.next = node;
        }
        return head;
    }

    static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        SinglyLinkedListNode second = new SinglyLinkedListNode(2);
        SinglyLinkedListNode third = new SinglyLinkedListNode(3);
        head.next = second;
        second.next = third;
        SinglyLinkedListNode newList = insertNodeAtPosition(head, 0, 2);
        printLinkedList(newList);
    }
}
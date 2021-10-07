package Week4;

import java.io.*;
import java.util.*;

public class InsertTail {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);

        if (head == null) {
            head = node;
        } else {
            SinglyLinkedListNode lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = node;
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
        head.next = second; // Link first node with the second node
        second.next = third;
        insertNodeAtTail(head, 4);
        printLinkedList(head);
    }
}

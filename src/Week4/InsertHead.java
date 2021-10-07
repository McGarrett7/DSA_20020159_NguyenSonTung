package Week4;

public class InsertHead {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        if (llist != null) {
            node.next = llist;
        }
        return node;
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
        SinglyLinkedListNode newList = insertNodeAtHead(head, 0);
        printLinkedList(newList);
    }
}
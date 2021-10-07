package Week4;

public class DeleteNode {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if (position == 0) {
            head = head.next;
        } else {
            SinglyLinkedListNode p = head;
            while (--position != 0) {
                p = p.next;
            }
            p.next = p.next.next;
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
        SinglyLinkedListNode newList = deleteNode(head, 2);
        printLinkedList(newList);
    }
}
package Week4;

public class PrintReserve {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static void reversePrint(SinglyLinkedListNode head) {
        if (head.next != null) {
            reversePrint(head.next);
        }
        System.out.println(head.data);
    }

    public static void main(String[] args) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        SinglyLinkedListNode second = new SinglyLinkedListNode(2);
        SinglyLinkedListNode third = new SinglyLinkedListNode(3);
        head.next = second;
        second.next = third;
        reversePrint(head);
    }
}
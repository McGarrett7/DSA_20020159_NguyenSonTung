package Week4;

public class GetNodeValue {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode node = head, result = head;
        while (positionFromTail-- != 0) {
            node = node.next;
        }

        while (node.next != null) {
            node = node.next;
            result = result.next;
        }

        return result.data;
    }

//    static void printLinkedList(SinglyLinkedListNode head) {
//        SinglyLinkedListNode node = head;
//        while (node != null) {
//            System.out.println(node.data);
//            node = node.next;
//        }
//    }

    public static void main(String[] args) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        SinglyLinkedListNode second = new SinglyLinkedListNode(2);
        SinglyLinkedListNode third = new SinglyLinkedListNode(3);
        head.next = second;
        second.next = third;
        getNode(head, 2);
    }
}
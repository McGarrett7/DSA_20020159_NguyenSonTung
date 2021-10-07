package Week4;

public class MergeList {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        if (head1.data < head2.data) {
            head1.next = mergeLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeLists(head1, head2.next);
            return head2;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedListNode head1 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode head2 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode third = new SinglyLinkedListNode(3);
        head1.next = third;
        head2.next = third;
        mergeLists(head1, head2);
    }
}
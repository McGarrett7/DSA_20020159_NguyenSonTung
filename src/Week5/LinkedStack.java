package Week5;

import java.util.Iterator;

public class LinkedStack<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T d, Node<T> n) {
            data = d;
            next = n;
        }
    }

    public LinkedStack() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void push(T item) {
        head = new Node<T>(item, head);
        size++;
    }

    public void pop() {
        if (!isEmpty()) {
            head = head.next;
            size--;
        }
    }

    public T getFirst() {
        if (!isEmpty()) {
            return head.data;
        } else {
            return null;
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T item = current.data;
                    current = current.next;
                    return item;
                } else {
                    return null;
                }
            }
        };
    }

    public static void main(String[] args) {
        LinkedStack<String> s = new LinkedStack<String>();
        s.push("A");
        s.push("B");
        s.push("C");
        System.out.println("Stack: " + s);

        s.pop();
        System.out.println("Stack: " + s);
        s.pop();
        System.out.println("Stack: " + s);

        s.push("D");
        System.out.println("Stack: " + s);
    }
}
//
//
//public class LinkedStack<Item> implements Iterable<Item> {
//    private int n;          // size of the stack
//    private Node first;     // top of stack
//
//    // helper linked list class
//    private class Node {
//        private Item item;
//        private Node next;
//    }
//
//    /**
//     * Initializes an empty stack.
//     */
//    public LinkedStack() {
//        first = null;
//        n = 0;
//        assert check();
//    }
//
//    /**
//     * Is this stack empty?
//     * @return true if this stack is empty; false otherwise
//     */
//    public boolean isEmpty() {
//        return first == null;
//    }
//
//    /**
//     * Returns the number of items in the stack.
//     * @return the number of items in the stack
//     */
//    public int size() {
//        return n;
//    }
//
//    /**
//     * Adds the item to this stack.
//     * @param item the item to add
//     */
//    public void push(Item item) {
//        Node oldfirst = first;
//        first = new Node();
//        first.item = item;
//        first.next = oldfirst;
//        n++;
//        assert check();
//    }
//
//    /**
//     * Removes and returns the item most recently added to this stack.
//     * @return the item most recently added
//     * @throws java.util.NoSuchElementException if this stack is empty
//     */
//    public Item pop() {
//        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
//        Item item = first.item;        // save item to return
//        first = first.next;            // delete first node
//        n--;
//        assert check();
//        return item;                   // return the saved item
//    }
//
//
//    /**
//     * Returns (but does not remove) the item most recently added to this stack.
//     * @return the item most recently added to this stack
//     * @throws java.util.NoSuchElementException if this stack is empty
//     */
//    public Item peek() {
//        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
//        return first.item;
//    }
//
//    /**
//     * Returns a string representation of this stack.
//     * @return the sequence of items in the stack in LIFO order, separated by spaces
//     */
//    public String toString() {
//        StringBuilder s = new StringBuilder();
//        for (Item item : this)
//            s.append(item + " ");
//        return s.toString();
//    }
//
//    /**
//     * Returns an iterator to this stack that iterates through the items in LIFO order.
//     * @return an iterator to this stack that iterates through the items in LIFO order.
//     */
//    public Iterator<Item> iterator() {
//        return new LinkedIterator();
//    }
//
//    // an iterator, doesn't implement remove() since it's optional
//    private class LinkedIterator implements Iterator<Item> {
//        private Node current = first;
//        public boolean hasNext()  { return current != null;                     }
//        public void remove()      { throw new UnsupportedOperationException();  }
//
//        public Item next() {
//            if (!hasNext()) throw new NoSuchElementException();
//            Item item = current.item;
//            current = current.next;
//            return item;
//        }
//    }
//
//
//    // check internal invariants
//    private boolean check() {
//
//        // check a few properties of instance variable 'first'
//        if (n < 0) {
//            return false;
//        }
//        if (n == 0) {
//            if (first != null) return false;
//        }
//        else if (n == 1) {
//            if (first == null)      return false;
//            if (first.next != null) return false;
//        }
//        else {
//            if (first == null)      return false;
//            if (first.next == null) return false;
//        }
//
//        // check internal consistency of instance variable n
//        int numberOfNodes = 0;
//        for (Node x = first; x != null && numberOfNodes <= n; x = x.next) {
//            numberOfNodes++;
//        }
//        if (numberOfNodes != n) return false;
//
//        return true;
//    }
//}

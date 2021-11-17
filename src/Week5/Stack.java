package Week5;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private T[] data;
    private int size;

    //Initializes an empty stack.
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    //Returns true if this stack is empty.
    public boolean isEmpty() {
        return size == 0;
    }

    //Returns the number of items in this stack.
    public int size() {
        return size;
    }

    //Adds the item to this stack.
    public void push(T item) {
        if (size < data.length) {
            data[size++] = item;
        }
    }

     //Removes and returns the item most recently added to this stack.
    public void pop() {
        if (!isEmpty()) {
            size--;
        }
    }

    public T peek() {
        if (!isEmpty()) {
            return data[size-1];
        } else {
            return null;
        }
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return the sequence of items in this stack in LIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item : this)
            s.append(item + " ");               // concatenate string
        return s.toString();
    }

    //Returns an iterator to this stack that iterates through the items.
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int i = size - 1;

            @Override
            public boolean hasNext() {
                return i >= 0;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    return data[i--];
                } else {
                    return null;
                }
            }
        };
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<String>(10);
        s.push("A");
        s.push("B");
        System.out.println("Stack: " + s);
        s.push("C");
        System.out.println("Stack: " + s);

        s.pop();
        System.out.println("Stack: " + s);
        s.pop();
        System.out.println("Stack: " + s);
        s.pop();
        System.out.println("Stack: " + s);

        s.push("D");
        System.out.println("Stack: " + s);
    }
}


//public class Stack<Item> implements Iterable<Item> {
//    private Node<Item> first;     // top of stack
//    private int n;                // size of the stack
//
//    // helper linked list class
//    private static class Node<Item> {
//        private Item item;
//        private Node<Item> next;
//    }
//
//    /**
//     * Initializes an empty stack.
//     */
//    public Stack() {
//        first = null;
//        n = 0;
//    }
//
//    /**
//     * Returns true if this stack is empty.
//     *
//     * @return true if this stack is empty; false otherwise
//     */
//    public boolean isEmpty() {
//        return first == null;
//    }
//
//    /**
//     * Returns the number of items in this stack.
//     *
//     * @return the number of items in this stack
//     */
//    public int size() {
//        return n;
//    }
//
//    /**
//     * Adds the item to this stack.
//     *
//     * @param  item the item to add
//     */
//    public void push(Item item) {
//        Node<Item> oldfirst = first;
//        first = new Node<Item>();
//        first.item = item;
//        first.next = oldfirst;
//        n++;
//    }
//
//    /**
//     * Removes and returns the item most recently added to this stack.
//     *
//     * @return the item most recently added
//     * @throws NoSuchElementException if this stack is empty
//     */
//    public Item pop() {
//        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
//        Item item = first.item;        // save item to return
//        first = first.next;            // delete first node
//        n--;
//        return item;                   // return the saved item
//    }
//
//
//    /**
//     * Returns (but does not remove) the item most recently added to this stack.
//     *
//     * @return the item most recently added to this stack
//     * @throws NoSuchElementException if this stack is empty
//     */
//    public Item peek() {
//        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
//        return first.item;
//    }
//
    /**
     * Returns a string representation of this stack.
     *
     * @return the sequence of items in this stack in LIFO order, separated by spaces
     */
//    public String toString() {
//        StringBuilder s = new StringBuilder();
//        for (Item item : this) {
//            s.append(item);
//            s.append(' ');
//        }
//        return s.toString();
//    }
//
//
    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     *
     * @return an iterator to this stack that iterates through the items in LIFO order
     */
//    public Iterator<Item> iterator() {
//        return new LinkedIterator(first);
//    }
//
    // an iterator, doesn't implement remove() since it's optional
//    private class LinkedIterator implements Iterator<Item> {
//        private Node<Item> current;

//        public LinkedIterator(Node<Item> first) {
//            current = first;
//        }
//
//        public boolean hasNext() {
//            return current != null;
//        }
//
//        public void remove() {
//            throw new UnsupportedOperationException();
//        }
//
//        public Item next() {
//            if (!hasNext()) throw new NoSuchElementException();
//            Item item = current.item;
//            current = current.next;
//            return item;
//        }
//    }
//}
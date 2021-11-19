package Coursera.Week5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item data;
        Node pre;
        Node next;

        Node(Item data) {
            this.data = data;
            pre = null;
            next = null;
        }

    }

    // construct an empty deque
    public Deque() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();

        Node oldFirst = first;
        first = new Node(item);

        if (isEmpty()) {
            last = first;
        } else {
            first.next = oldFirst;
            oldFirst.pre = first;
        }

        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();

        Node oldLast = last;
        last = new Node(item);

        if (isEmpty()) {
            first = last;
        } else {
            last.pre = oldLast;
            oldLast.next = last;
        }

        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        Item ans = first.data;
        size--;

        if (isEmpty()) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.pre = null;
        }

        return ans;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        Item ans = last.data;
        size--;

        if (isEmpty()) {
            first = null;
            last = null;
        } else {
            last = last.pre;
            last.next = null;
        }

        return ans;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        System.out.println("Empty: " + deque.isEmpty());
        System.out.println("Size: " + deque.size());
        deque.addFirst(2);
        deque.addLast(3);
        deque.addFirst(3123);
        System.out.println(deque.removeFirst());
        deque.addLast(323123);
        System.out.println(deque.removeLast());
        deque.addLast(4);
        deque.addFirst(1);

        System.out.println("Empty: " + deque.isEmpty());
        System.out.println("Size: " + deque.size());
        for (Integer i: deque) {
            System.out.println(i + " ");
        }
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item ans = current.data;
            current = current.next;
            return ans;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
package Coursera.Week5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        private Item item;
        private Node pre;
        private Node next;
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
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        first.pre = null;
        if (isEmpty()) {
            last = first;
        } else {
            oldFirst.pre = first;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();

        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.pre = oldLast;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        Item n = first.item;
        size--;

        if (isEmpty()) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.pre = null;
        }

        return n;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        Item n = last.item;
        size--;

        if (isEmpty()) {
            first = null;
            last = null;
        } else {
            last = last.pre;
            last.next = null;
        }
        return n;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item ans = current.item;
            current = current.next;
            return ans;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> test = new Deque<>();
        System.out.println(test.size());
        test.addFirst(5);
        test.addFirst(3);
        test.addFirst(2);
        test.addFirst(9);
        test.addLast(7);
        System.out.println(test.removeFirst());
        System.out.println(test.size());
        System.out.println(test.removeLast());
        }
    }
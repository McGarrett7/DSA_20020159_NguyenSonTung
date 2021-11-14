package Coursera.Week5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node pre;
    }

    // construct an empty deque
    public Deque(){}

    // is the deque empty?
    public boolean isEmpty(){
        return size == 0;
    }

    // return the number of items on the deque
    public int size(){
        return size;
    }

    // add the item to the front
    public void addFirst(Item item){
        if (item == null)
            throw new IllegalArgumentException("item is null");

        Node newNode = new Node();
        newNode.item = item;

        if (size == 0) {
            first = newNode;
            last = newNode;
        }
        else {
            newNode.next = first;
            first.pre = newNode;
            first = newNode;
            newNode.pre = null;
        }
        this.size++;
    }

    // add the item to the back
    public void addLast(Item item){
        if (item == null)
            throw new IllegalArgumentException("item is null");

        Node newNode = new Node();
        newNode.item = item;

        if (size == 0) {
            first = newNode;
            last = newNode;
        }
        else {
            last.next = newNode;
            newNode.pre = last;
            last = newNode;
            newNode.next = null;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if (size == 0)
            throw new NoSuchElementException("Deque is empty");

        Item returnItem = first.item;

        if (size == 1) {
            first = null;
            last = null;
        }
        else {
            first = first.next;
            first.pre = null;
        }
        size--;

        return returnItem;
    }

    // remove and return the item from the back
    public Item removeLast(){
        if (size == 0)
            throw new NoSuchElementException("Deque is empty");
        Item returnItem = last.item;

        if (size == 1) {
            first = null;
            last = null;
        }
        else {
            last = last.pre;
            last.next = null;
        }
        size--;
        return returnItem;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node cur = first;

        @Override
        public boolean hasNext() {
            return (cur != null);
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("No more Objects in the deque");

            Item returnItem = cur.item;
            cur = cur.next;

            return returnItem;
        }
    }

    // unit testing (required)
    public static void main(String[] args){
        Deque<String> deque = new Deque<String>();
        System.out.println(deque.size());
        deque.addFirst("2");
        deque.addFirst("5");
        deque.addFirst("7");
        deque.addFirst("9");
        deque.addLast("10");
        System.out.println(deque.size());
        Iterator<String> iter = deque.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
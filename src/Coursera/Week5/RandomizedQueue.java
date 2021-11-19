package Coursera.Week5;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] queue = (Item[]) new Object[1];
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (size == queue.length) {
            Item[] temp = (Item[]) new Object[2 * queue.length];
            for (int i = 0; i < size; i++) {
                temp[i] = queue[i];
            }
            queue = temp;
        }
        queue[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();

        Item item = this.queue[--size];
        if (size > 0 && size == this.queue.length / 4) {
            Item[] temp = (Item[]) new Object[queue.length / 2];
            for (int i = 0; i < size; i++) {
                temp[i] = queue[i];
            }
            queue = temp;
        }
        queue[size] = null;
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size() == 0) {
            throw new java.util.NoSuchElementException();
        }
        return queue[StdRandom.uniform(0, size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomListIterator();
    }

    private class RandomListIterator implements Iterator<Item> {
        private final Item[] itemsCopy;
        private int count;

        public RandomListIterator() {
            itemsCopy = itemsCopy();
            count = size;
        }

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Item next() {
            if (count == 0) throw new NoSuchElementException();

            int index = StdRandom.uniform(count);
            Item ans =  itemsCopy[index];
            itemsCopy[index] = itemsCopy[--count];

            return ans;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private Item[] itemsCopy() {
            Item[] ans = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                ans[i] = queue[i];
            }
            return ans;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> test = new RandomizedQueue<>();
        test.enqueue("t");
        test.enqueue("u");
        test.enqueue("n");
        test.enqueue("g");
        test.dequeue();
        System.out.println(test.size());
    }
}
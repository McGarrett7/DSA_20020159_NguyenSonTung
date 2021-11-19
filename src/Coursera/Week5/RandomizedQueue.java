package Coursera.Week5;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        this.items = (Item[]) new Object[1];
        this.size = 0;
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
        if (size == items.length) {
            Item[] newItems = (Item[]) new Object[items.length * 2];
            for (int i = 0; i < size; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();

        // pick random index from 0 to size-1
        int index = StdRandom.uniform(size);

        // remember Item ans for returning
        Item ans = items[index];

        // move last Item to index
        items[index] = items[--size];
        items[size] = null;

        // if size is lower than 1/4 items.length -> shrink
        if ((double) size / items.length <= 0.25) {
            Item[] newItems = (Item[]) new Object[items.length/2 + 1];
            for (int i = 0; i < size; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        return ans;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        int index = StdRandom.uniform(size);
        return items[index];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        System.out.println("Is empty: " + queue.isEmpty());
        System.out.println("Size = " + queue.size());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Is empty: " + queue.isEmpty());
        System.out.println("Size = " + queue.size());

        Integer i1 = queue.dequeue();
        System.out.println("i1 = " + i1);
        System.out.println("Size = " + queue.size());

        queue.enqueue(i1);

        System.out.println("Sample: " + queue.sample() + " " + queue.sample() + " " + queue.sample());

        for (Integer i : queue) {
            System.out.println(i + " ");
        }

        for (int i = 4; i < 10; i++) {
            queue.enqueue(i);
        }

        for (Integer i : queue) {
            System.out.print(i + " ");
        }

    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private final Item[] itemsCopy;
        private int count;

        public RandomizedQueueIterator() {
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
                ans[i] = items[i];
            }
            return ans;
        }
    }
}
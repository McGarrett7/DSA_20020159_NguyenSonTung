package Coursera.Week5;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] queue;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue(){
    }

    // is the randomized queue empty?
    public boolean isEmpty(){
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size(){
        return size;
    }

    // add the item
    public void enqueue(Item item){
        if (item == null)
            throw new NullPointerException("Item is null");
        if (size == queue.length) {
            Item[] resizedQueue = (Item[]) new Object[queue.length * 2];
            for (int i = 0; i < queue.length; i++)
                resizedQueue[i] = queue[i];
            queue = resizedQueue;
        }

        queue[size++] = item;
    }

    // remove and return a random item
    public Item dequeue(){
        if (size == 0)
            throw new NoSuchElementException("The RandomizeQueue is empty");
        int seed = StdRandom.uniform(0, size);

        Item returnItem = queue[seed];

        size--;
        queue[seed] = queue[size];
        queue[size] = null;// Avoid loitering

        if (queue.length > 4 && size < queue.length / 4) {
            Item[] resizedQueue = (Item[]) new Object[queue.length / 2];

            for (int i = 0; i < size; i++) {
                resizedQueue[i] = queue[i];
            }
            queue = resizedQueue;
        }
        return returnItem;
    }

    // return a random item (but do not remove it)
    public Item sample(){
        if (size == 0)
            throw new NoSuchElementException("The RandomizeQueue is empty");
        return queue[StdRandom.uniform(0, size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new RandomIterator(queue, size);
    }

    private class RandomIterator implements Iterator<Item> {
        private Item[] iteratorQueue;
        private int iteratorIndex = 0;

        public RandomIterator(Item[] queue, int size) {
            iteratorQueue = (Item[]) new Object[size];

            for (int i = 0; i < iteratorQueue.length; i++) {
                iteratorQueue[i] = queue[i];
            }

            for (int j = 1; j < iteratorQueue.length; j++) {
                int swapIndex = StdRandom.uniform(j + 1);

                Item temp = iteratorQueue[j];
                iteratorQueue[j] = iteratorQueue[swapIndex];
                iteratorQueue[swapIndex] = temp;
            }
        }

        @Override
        public boolean hasNext() {
            return (iteratorIndex < iteratorQueue.length);
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Queue is empty");
            }

            Item item = iteratorQueue[iteratorIndex];
            iteratorIndex++;
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args){  RandomizedQueue<String> queue = new RandomizedQueue<>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.dequeue();
        Iterator<String> iterO = queue.iterator();
        Iterator<String> iter1 = queue.iterator();
        while (iterO.hasNext()) {
            System.out.println(iterO.next());
        }
        System.out.println();
        while (iter1.hasNext()) {
            System.out.println(iter1.next());
        }
        System.out.println();
    }
}
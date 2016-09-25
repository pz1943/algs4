import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;


public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] data;
    private int count;
    
    public RandomizedQueue() {                
        // construct an empty randomized queue
        data = (Item[]) new Object[1];
        count = 0;
    }
    public boolean isEmpty() {                
        // is the queue empty?
        return count == 0;
    }
    public int size() {                       
        // return the number of items on the queue
        return count;
    }
    public void enqueue(Item item) {          
        // add the item
        if (item == null) throw new java.lang.NullPointerException();
        if (data.length == count) {
            Item[] doubleSizeData = (Item[]) new Object[count*2];
            for (int i = 0; i < count; i++) {
                doubleSizeData[i] = data[i];
            }
            data = doubleSizeData;
        }
        data[count] = item;
        count++;
    }
    public Item dequeue() {                   
        // remove and return a random item
        if (data.length/2 > count) {
            Item[] halfSizeData = (Item[]) new Object[data.length / 2];
            for (int i = 0; i < data.length/2; i++) {
                halfSizeData[i] = data[i];
            }
            data = halfSizeData;
        }
        if (count > 0) {
            int n = StdRandom.uniform(count);
            Item item = data[n];
            data[n] = data[count - 1];
            data[count - 1] = null;
            count--;
            return item;
        } else throw new java.util.NoSuchElementException();
    }

    public Item sample() {                    
        // return (but do not remove) a random item
        if (count == 0) throw new java.util.NoSuchElementException();
        int n = StdRandom.uniform(count);
        return data[n];
    }
    
    private class ShuffledIterator implements Iterator<Item> {
        private int i;
        private Item[] shuffledData;
        public ShuffledIterator() {
            i = count - 1;
            shuffledData = (Item[]) new Object[count];
            for (int j = 0; j < count; j++) {
                shuffledData[j] = data[j];
            }
            StdRandom.shuffle(shuffledData);
        }
        
        public boolean hasNext() {
            return i >= 0;
        }
        
        public Item next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            return shuffledData[i--];
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    public Iterator<Item> iterator() {        
        // return an independent iterator over items in random order
        return new ShuffledIterator();
    }
    public static void main(String[] args) {  
        // unit testing
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
        for (int item : queue) {
            StdOut.printf("%3d", item);
            
        }
    }
}
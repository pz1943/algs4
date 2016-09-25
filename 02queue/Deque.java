import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> previous;
    }
    
    private Node<Item> first;
    private Node<Item> end;
    private int count = 0;
    
    public Deque() {
        // construct an empty deque
        count = 0;
        first = null;
        end = null;
    }

    public boolean isEmpty() {
        // is the deque empty?
        return count == 0;
    }

    public int size() {
        // return the number of items on the deque
        return count;
    }

    public void addFirst(Item item) {         
        // add the item to the front
        if (item == null)
            throw new java.lang.NullPointerException();
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.next = oldFirst;
        first.item = item;
        if (oldFirst == null)
            end = first;
        else oldFirst.previous = first;
        count++;
    }
    public void addLast(Item item) {          
        // add the item to the end
        if (item == null)
            throw new java.lang.NullPointerException();
        Node<Item> oldLast = end;
        end = new Node<Item>();
        end.previous = oldLast;
        end.item = item;
        if (oldLast == null)
            first = end;
        else oldLast.next = end;
        count++;
    }
    public Item removeFirst() {
        // remove and return the item from the front
        
        if (count == 0) 
            throw new java.util.NoSuchElementException();
        if (count > 0) {
            Node<Item> oldFirst = first;
            first = oldFirst.next;
            if (first != null)
                first.previous = null;
            else end = null;
            count--;
            return oldFirst.item;
        } else { return null; }
    }
    public Item removeLast() {
        // remove and return the item from the end
        if (count == 0) 
            throw new java.util.NoSuchElementException();
        if (count > 0) {
            Node<Item> oldLast = end;
            end = oldLast.previous;
            if (end != null) 
                end.next = null;
            else first = null;
            count--;
            return oldLast.item;
        } else { return null; }
    }

    public Iterator<Item> iterator() {        
        // return an iterator over items in order from front to end
        return new DequesIterator<Item>(first);
    }

    private class DequesIterator<Item> implements Iterator<Item> {
        private Node<Item> current;
        
        public DequesIterator(Node<Item> first) {
            current = first;
        }
        
        public boolean hasNext() {
            return current != null;
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
        public Item next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
        
    public static void main(String[] args) {   
        // unit testing
        Deque<Integer> deque = new Deque<Integer>();

    }
}
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Subset {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        RandomizedQueue<String> randQueue = new RandomizedQueue<String>();
        while(!StdIn.isEmpty()) {
            randQueue.enqueue(StdIn.readString());
        }

        for (int i = 0; i < n; i++) {
            StdOut.printf("%s\n", randQueue.dequeue());
        }
    }
}
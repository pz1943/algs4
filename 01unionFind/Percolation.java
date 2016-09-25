import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Percolation {
   private boolean[] openFlag;
   private int gridSize;
   private WeightedQuickUnionUF quickUnionUF;
   
   public Percolation(int n) {         
// create n-by-n grid, with all sites blocked
       validate(n);
       quickUnionUF = new WeightedQuickUnionUF(n*n + 2);
       openFlag = new boolean[n*n + 2];
       gridSize = n;
       
       for (int i = 0; i < n*n + 2; i++) {
           openFlag[i] = false;
       }
       openFlag[n*n] = true;
       openFlag[n*n + 1] = true;
   }
   
   private void validate(int n) {
       if (n <= 0) {
           throw new IllegalArgumentException("n out of range");
       }
   }
   

   private void validate(int i, int j) {
       if (i <= 0 || i > gridSize) {
           throw new IndexOutOfBoundsException("i out of range");
       }
       
       if (j <= 0 || j > gridSize) {
           throw new IndexOutOfBoundsException("j out of range");
       }
   }
   
   private int xyTo1D(int row, int col) {
       return (row - 1) * gridSize + col - 1;
   }
   public void open(int i, int j) {      
       validate(i, j);
// open site (row i, column j) if it is not open already
       if (!isOpen(i, j))
       {
           openFlag[xyTo1D(i, j)] = true;
           if (j > 1) {
               if (isOpen(i, j - 1)) {
                   quickUnionUF.union(xyTo1D(i, j), xyTo1D(i, j - 1));
               }
           }
           
           if (j < gridSize) {
               if (isOpen(i, j + 1)) {
                   quickUnionUF.union(xyTo1D(i, j), xyTo1D(i, j + 1));
               }
           }
           if (i < gridSize) {
               if (isOpen(i + 1, j)) {
                   quickUnionUF.union(xyTo1D(i, j), xyTo1D(i + 1, j));
               }
           }
           else if (i == gridSize) {
               quickUnionUF.union(xyTo1D(i, j), xyTo1D(gridSize + 1, 2));
           }
           
           if (i > 1) {
               if (isOpen(i - 1, j)) {
                   quickUnionUF.union(xyTo1D(i, j), xyTo1D(i - 1, j));
               }
           }
           else if (i == 1) {
               quickUnionUF.union(xyTo1D(i, j), xyTo1D(gridSize + 1, 1));
           }
       }
   }
   
   public boolean isOpen(int i, int j) {     // is site (row i, column j) open?
       validate(i, j);
       return openFlag[xyTo1D(i, j)];
   }
       
   public boolean isFull(int i, int j) {     // is site (row i, column j) full?   
       validate(i, j);
       return quickUnionUF.connected(xyTo1D(i, j), xyTo1D(gridSize + 1, 1));
   }

   public boolean percolates() {            // does the system percolate?
       return quickUnionUF.connected(gridSize*gridSize, gridSize * gridSize + 1);
   }
   
   public static void main(String[] args) {  // test client (optional)
       int n = StdIn.readInt();
       int count = 0;
       Percolation myPercolation = new Percolation(n);
       int row = 1;
       int col = 1;
       while (!myPercolation.percolates()) {
           while (myPercolation.isOpen(row, col)) {
               row = StdRandom.uniform(n) + 1;
               col = StdRandom.uniform(n) + 1;
           }
           myPercolation.open(row, col);
           count++;
       }
       StdOut.println(count);
   }
}

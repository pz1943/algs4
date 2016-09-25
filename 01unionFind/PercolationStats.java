import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {
//   private int n;
   private double[] result;
   public PercolationStats(int n, int trials) {    
// perform trials independent experiments on an n-by-n grid
       validate(n, trials);
       result = new double[trials];
       double count = 0.0;
       for (int i = 0; i < trials; i++) {
           count = 0.0;
           Percolation myPercolation = new Percolation(n);
           int row = 1;
           int col = 1;
           do {
               do {
                   row = StdRandom.uniform(n) + 1;
                   col = StdRandom.uniform(n) + 1;
               } while (myPercolation.isOpen(row, col));
               myPercolation.open(row, col);
               count++;
           } while (!myPercolation.percolates());
           result[i] = count/ (n * n);
//           StdOut.println(result[i]);
       }
   }
   
   private void validate(int n, int trails) {
       if (n <= 0) {
           throw new IllegalArgumentException("n out of range");
       }
       if (trails <= 0) {
           throw new IllegalArgumentException("trails out of range");
       }
   }
      
   public double mean() {                         
// sample mean of percolation threshold
       return StdStats.mean(result);
   }
   public double stddev() {                       
// sample standard deviation of percolation threshold
       return StdStats.stddev(result);
   }
   public double confidenceLo() {                 
// low  endpoint of 95% confidence interval
       double mean = mean();
       double dev = stddev();
       return (mean - 1.96 * dev / Math.sqrt(result.length));
   }
   public double confidenceHi() {                  
// high endpoint of 95% confidence interval
       double mean = mean();
       double dev = stddev();
       return (mean + 1.96 * dev / Math.sqrt(result.length));
   }

   public static void main(String[] args) {   // test client (described below)
       int n = StdIn.readInt();
       int trials = StdIn.readInt();
       Stopwatch timer = new Stopwatch();
       
       PercolationStats perStats = new PercolationStats(n, trials);
       
       StdOut.printf("%-25s%-4s", "mean", " = ");
       StdOut.printf("%3.15f\n", perStats.mean());
       StdOut.printf("%-25s%-4s", "stddev", " = ");
       StdOut.printf("%3.15f\n", perStats.stddev());
       StdOut.printf("%-25s%-4s", "95% confidence interval", " = ");
       StdOut.printf("%3.15f,%3.15f\n", perStats.confidenceLo(), perStats.confidenceHi());
       StdOut.printf("%-25s%-4s%3.15f\n", "elapsed time", " = ", timer.elapsedTime());
   }
}
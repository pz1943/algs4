public class PercolationWithWeightQuickUnion {
   private int[] id;
   private boolean[] openFlag;
   private int dimension;
   private int[] weight;
   
   public PercolationWithWeightQuickUnion(int n) {              // create n-by-n grid, with all sites blocked
       id = new int[n*n + 2];
       openFlag = new boolean[n*n + 2];
       weight = new int[n* n + 2];
       dimension = n;
//       count = n*n;
       for (int i = 0; i < n*n + 2; i ++) {
           id[i] = i;  
           openFlag[i] = false;
           weight[i] = 1;
       }
       openFlag[n*n] = true;
       openFlag[n*n + 1] = true;
       connectSides();
   }
   
   private void connectSides() {
       for (int i = 0; i < dimension; i++){
           openFlag[i] = true;
           union(0, i, dimension, 0);
           openFlag[i] = false;
           openFlag[dimension * dimension - dimension + i] = true;
           union(dimension - 1, i, dimension, 1);
           openFlag[dimension * dimension - dimension + i] = false;
       }
   }
   
   public boolean isConnected(int i, int j, int k, int l){
       return find(i, j) == find(k, l);
   }
   
   public int find(int i, int j) {
       validate(i, j);
       int p = i * dimension + j;
       while (p != id[p]) {
           id[p] = id[id[p]];
           p = id[p];
       }

       return p;
   }
   
   private void validate(int i, int j) {
       int n = id.length;
       if (i * dimension + j < 0 || i * dimension + j >= n) {
           throw new IndexOutOfBoundsException("out of range");
       }
   }
   
   public void union (int i, int j, int k, int l) {
       if( isOpen(i, j)) {
           if( isOpen(k, l)) {
              int rootP = find(i, j);
              int rootQ = find(k, l);
              if (rootP == rootQ) return;
//              if(weight[rootP] > weight[rootQ]) {
//                  id[rootQ] = rootP;
//              } else {
//                  if (weight[rootP] == weight[rootQ]) 
//                      weight[rootQ] += 1;
//                  id[rootP] = rootQ;
//              }
//              
              if(weight[rootP] > weight[rootQ]) {
                  id[rootQ] = rootP;
                  weight[rootP] += weight[rootQ];
              } else {
                  weight[rootQ] += weight[rootP];
                  id[rootP] = rootQ;
              }
           }
       }
   }
   
   public void open(int i, int j) {         // open site (row i, column j) if it is not open already
       validate(i, j);
       if( !isOpen(i, j))
       {
           openFlag[i * dimension + j] = true;
           if(j > 0)
               union(i, j, i, j - 1);
           if (j + 1 < dimension)
               union(i, j, i, j + 1);
           if (i + 1 < dimension)
               union(i, j, i + 1, j);
           if (i > 0)
               union(i, j, i - 1, j);
       }
   }
   
   public boolean isOpen(int i, int j){     // is site (row i, column j) open?
       validate(i, j);
       return openFlag[i*dimension + j];
   }
       
   public boolean isFull(int i, int j){     // is site (row i, column j) full?
       return !isOpen(i, j);
   }

   public boolean percolates() {            // does the system percolate?
       return isConnected(dimension, 0, dimension, 1);
   }
   
   public static void main(String[] args){  // test client (optional)
       int n = StdIn.readInt();
       int count = 0;
       Percolation myPercolation = new Percolation(n);
       
       while(!myPercolation.percolates()) {
           int row = 0;
           int col = 0;
           while(myPercolation.isOpen(row, col)) {
               row = StdRandom.uniform(n);
               col = StdRandom.uniform(n);
           }
//           StdOut.printf("row = %d, col = %d\n",row , col);
           myPercolation.open(row, col);
//           myPercolation.printCube();
//           myPercolation.printOpened();
           count++;
       }
       StdOut.println(count);
   }
   
      
   void printCube() {
       for(int i = 0; i < dimension; i++){
           for(int j = 0; j < dimension; j++){
               System.out.printf("%3d",id[i*dimension + j]);
           }
           System.out.print("\n");
       }   
       System.out.printf("%3d",id[dimension * dimension]);
       System.out.printf("%3d\n",id[dimension * dimension + 1]);
       System.out.print("-------------");
       System.out.print("\n");
   }
   private void printOpened() {
       for(int i = 0; i < dimension; i++){
           for(int j = 0; j < dimension; j++){
               System.out.printf("%3d",openFlag[i*dimension + j]? 1:0);
           }
           System.out.print("\n");
       }   
       System.out.print("-------------");
       System.out.print("\n");
   }
}

// email: pz1943@163.com



import java.util.Arrays;
import java.util.Iterator; 


public class Board implements Iterable<Board>{
    
    private int[][] blocks;
    private int dimension;
    private int moved;
    
    private int[][] copy2D(int[][] fromBlocks) {
        int[][] toBlocks = new int[fromBlocks.length][fromBlocks.length];
        for (int i = 0; i < dimension; i++) 
            for (int j = 0; j < dimension; j++) 
            toBlocks[i][j] = fromBlocks[i][j];
        return toBlocks;
    }
    
    public Board(int[][] inBlocks)  {
        // construct a board from an n-by-n array of blocks
        // (where blocks[i][j] = block in row i, column j)
        dimension = inBlocks.length;
        blocks = copy2D(inBlocks);
    }
    public int dimension() {                // board dimension n
        return dimension;
    }
    public int hamming() {
        // number of blocks out of place
        int count = 0;
        for (int i = 0; i < dimension; i++) 
            for (int j = 0; j < dimension; j++) 
            if (blocks[i][j] != i*dimension + j + 1 & blocks[i][j] != 0) count++;
        return count + moved;
    }
    public int manhattan() {
        // sum of Manhattan distances between blocks and goal
        int manhattan = 0;
        for (int i = 0; i < dimension; i++) 
            for (int j = 0; j < dimension; j++) {
            int block = blocks[i][j];
            if (block == 0) continue;
            int row = (block - 1) / dimension;
            int col = (block - 1) % dimension;
            manhattan += Math.abs(row + col - i - j);
        }
        return manhattan;
    }
    public boolean isGoal() {
        // is this board the goal board?
        return (hamming() - moved == 0) ? true : false;
    }
    public Board twin() {
        // a board that is obtained by exchanging any pair of blocks
        int[][] twin = copy2D(blocks);
        twin[0][0] = blocks[0][1];
        twin[0][1] = blocks[0][0];
        return new Board(twin);
    }
    public boolean equals(Object y) {
        // does this board equal y?
        if (y instanceof Board) 
            if (((Board) y).toString().equals(toString())) return true;
        return false;
    }
    
    public Iterable<Board> neighbors() {
        // all neighboring boards
        return this;
    }
    
    public Iterator<Board> iterator() {
        // all neighboring boards
        return new nbIterator();
    }
    
    private class nbIterator implements Iterator<Board> {
        private int col;
        private int row;
        private int nbBlocks[][][] = new int[4][dimension][dimension];
        private int index = 0;
        
        public nbIterator() {
            for (row = 0; row < dimension; row++) {
                boolean flag = false;
                for (col = 0; col < dimension; col++) {
                    int block = blocks[row][col];
                    if (blocks[row][col] == 0) {
                       flag = true;
                        break;
                    }
                }
                if (flag == true) break;
            }
            if (row > 0) {
                nbBlocks[index] = copy2D(blocks);
                nbBlocks[index][row - 1][col] = blocks[row][col];
                nbBlocks[index][row][col] = blocks[row - 1][col];
                index++;
                moved++;
            }
            if (row < dimension - 1) {
                nbBlocks[index] = copy2D(blocks);
                nbBlocks[index][row + 1][col] = blocks[row][col];
                nbBlocks[index][row][col] = blocks[row + 1][col];
                index++;
                moved++;
            }
            if (col > 0) {
                nbBlocks[index] = copy2D(blocks);
                nbBlocks[index][row][col - 1] = blocks[row][col];
                nbBlocks[index][row][col] = blocks[row][col - 1];
                index++;
                moved++;
            }
            if (col < dimension - 1) {
                nbBlocks[index] = copy2D(blocks);
                nbBlocks[index][row][col + 1] = blocks[row][col];
                nbBlocks[index][row][col] = blocks[row][col + 1];
                index++;
                moved++;
            }
        }
        
        public boolean hasNext() {
            return index != 0;
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
        public Board next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            return new Board(nbBlocks[--index]);
        }
    }
    public String toString() {
        // string representation of this board (in the output format specified below)
        
        StringBuilder s = new StringBuilder();
        s.append(dimension + "\n");
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                s.append(String.format("%2d ", blocks[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }
    
    public static void main(String[] args) {
        // unit tests (not graded)
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
            blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);
        StdOut.println(initial);
        StdOut.printf("manhattan = %2d\n", initial.manhattan());
        StdOut.printf("hamming = %2d\n", initial.hamming());
        
        StdOut.printf("isgoal = %b\n", initial.isGoal());
        
        StdOut.println(initial.twin());
        StdOut.println(initial.twin().twin());
        StdOut.println(initial.equals(initial.twin().twin()));
        for(Board board : initial.neighbors()) {
            
            StdOut.println(board);
        }


    }
}
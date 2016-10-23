// email: pz1943@163.com

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import java.util.Arrays;

public class Board {
    
    private int[] blocks;
    private int length;
    private int manhattan;
    private int dimension;
    
    public Board(int[][] inBlocks)  {
        // construct a board from an n-by-n array of blocks
        // (where blocks[i][j] = block in row i, column j)
        dimension = inBlocks.length;
        length = dimension * dimension;
        blocks = new int[length];
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++) {
            blocks[i*dimension + j] = inBlocks[i][j];
        }
        for (int i = 0; i < dimension; i++) 
            for (int j = 0; j < dimension; j++) {
            int block = blocks[i*dimension + j];
            if (block == 0) continue;
            int row = (block - 1) / dimension;
            int col = (block - 1) % dimension;
            manhattan += Math.abs(row - i) + Math.abs(col - j);
        }
    }
    
    private Board(int[] inBlocks, int manhattan)  {
        // construct a board from an n-by-n array of blocks
        // (where blocks[i][j] = block in row i, column j)
        length = inBlocks.length;
        dimension = (int) Math.sqrt(length);
        blocks = Arrays.copyOf(inBlocks, length);
        this.manhattan = manhattan;
    }
    
    public int dimension() {                // board length n
        return dimension;
    }
    
    public int hamming() {
        // number of blocks out of place
        int count = 0;
        for (int i = 0; i < length; i++) 
            if (blocks[i] != i + 1 && blocks[i] != 0) count++;
        return count;
    }
    public int manhattan() {
        // sum of Manhattan distances between blocks and goal
        return manhattan;
    }
    public boolean isGoal() {
        // is this board the goal board?
        return (hamming() == 0) ? true : false;
    }
    public Board twin() {
        // a board that is obtained by exchanging any pair of blocks
        int[] twin = Arrays.copyOf(blocks, length);
        if (twin.length == 1) return new Board(twin, manhattan);
        int i = 0;
        int j = 0;
        if (blocks[0] == 0) {
            i = 1;
            j = 3;
        } else if (blocks[1] == 0) {
            j = 2;
        } else {
            j = 1;
        }
        twin[i] = blocks[j];
        twin[j] = blocks[i];
        return new Board(twin, manhattan);
    }
    public boolean equals(Object y) {
        // does this board equal y?
        if (y != null)
            if (y.getClass().equals(this.getClass())) {
            if (((Board) y).blocks.length != length) return false;
            int[] yBlocks = ((Board) y).blocks;
            for (int i = 0; i < length; i++) {
                if (yBlocks[i] != blocks[i]) return false;
            }
            return true;
        }
        return false;
    }
    public Iterable<Board> neighbors() {
        // all neighboring boards
        return getNeighbors();
    }
    
//    private class NbIterator implements Iterator<Board> {
    
    private Stack<Board> getNeighbors() {
        int[] nbBlocks = new int[length];
        Board[] boards = new Board[4];
        int index = 0;
        int i;
        Stack<Board> neighbors = new Stack<Board>();
        for (i = 0; i < length; i++) 
            if (blocks[i] == 0) break;
        int row = i / dimension;
        int col = i % dimension;
        if (row > 0) {
            nbBlocks = Arrays.copyOf(blocks, length);
            nbBlocks[i - dimension] = 0;
            nbBlocks[i] = blocks[i - dimension];
            if ((blocks[i - dimension] - 1) / dimension < row) boards[index] = new Board(nbBlocks, manhattan + 1);
            else boards[index] = new Board(nbBlocks, manhattan - 1);
            index++;
        }
        if (row < dimension - 1) {
            nbBlocks = Arrays.copyOf(blocks, length);
            nbBlocks[i + dimension] = 0;
            nbBlocks[i] = blocks[i + dimension];
            if ((blocks[i + dimension] - 1) / dimension <= row) boards[index] = new Board(nbBlocks, manhattan - 1);
            else boards[index] = new Board(nbBlocks, manhattan + 1);
            index++;
        }
        if (col > 0) {
            nbBlocks = Arrays.copyOf(blocks, length);
            nbBlocks[i - 1] = 0;
            nbBlocks[i] = blocks[i - 1];
            if ((blocks[i - 1] - 1) % dimension < col) boards[index] = new Board(nbBlocks, manhattan + 1);
            else boards[index] = new Board(nbBlocks, manhattan - 1);
            index++;
        }
        if (col < dimension - 1) {
            nbBlocks = Arrays.copyOf(blocks, length);
            nbBlocks[i + 1] = 0;
            nbBlocks[i] = blocks[i + 1];
            if ((blocks[i + 1] - 1) % dimension <= col) boards[index] = new Board(nbBlocks, manhattan - 1);
            else boards[index] = new Board(nbBlocks, manhattan + 1);
            index++;
        }
        index--;
        for (; index >= 0; index--) neighbors.push(boards[index]);
        return neighbors;
    }
    public String toString() {
        // string representation of this board (in the output format specified below)
        StringBuilder s = new StringBuilder();
        s.append(dimension + "\n");
        for (int i = 0; i < length; i++) {
            s.append(String.format("%2d ", blocks[i]));
            if ((i + 1) % dimension == 0) s.append("\n");
        }
        return s.toString();
    }
    
    public static void main(String[] args) {
        // unit tests (not graded)
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
            blocks[i][j] = in.readInt();
        }
        Board initial = new Board(blocks);
        StdOut.println(initial);
        StdOut.printf("manhattan = %2d\n", initial.manhattan());
        StdOut.printf("hamming = %2d\n", initial.hamming());
//        StdOut.printf("isgoal = %b\n", initial.isGoal());
//        StdOut.println(initial.twin());
//        StdOut.println(initial.twin().twin());
//        StdOut.println(initial.equals(initial.twin().twin()));
    }
}
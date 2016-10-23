// email: pz1943@163.com

import java.util.Comparator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.MinPQ;
public class Solver {
    private NodeComparator cmp = new NodeComparator();
    private MinPQ<TreeNode> queue = new MinPQ<TreeNode>(cmp);
    private Stack<Board> stack = new Stack<Board>();
    private boolean isSolvable;
    public Solver(Board initial) {
        // find a solution to the initial board (using the A* algorithm)
        queue.insert(new TreeNode(initial));
        queue.insert(new TreeNode(initial.twin()));

        while (!queue.min().board.isGoal()) {
            TreeNode node = queue.delMin();
            TreeNode father = node.father;
            int moves = ++node.moves;
            if (father == null) {
                for (Board board : node.board.neighbors()) {
                    int priority = board.manhattan()+ moves;
                    queue.insert(new TreeNode(board, node, moves, priority));
                }
                continue;
            }
            for (Board board : node.board.neighbors()) {
                if (!board.equals(father.board)) {
                    int priority = board.manhattan() + moves;
                    queue.insert(new TreeNode(board, node, moves, priority));
                }
            }
        }
        isSolvable = initial.equals(writeResult().board);
    }
    public boolean isSolvable() {
        // is the initial board solvable?
        return isSolvable;
        
    }
    public int moves() {
        // min number of moves to solve initial board; -1 if unsolvable
        if (!isSolvable()) return -1;
        return stack.size() - 1;
    }
    public Iterable<Board> solution() {
        // sequence of boards in a shortest solution; null if unsolvable
        
        if (!isSolvable()) return null;
        return stack;
    }

    private TreeNode writeResult() {
        TreeNode node = queue.min();
        TreeNode initial = null;
        while (node != null) {
            stack.push(node.board);
            initial = node;
            node = node.father;
        }
        return initial;
    }
    
    private class NodeComparator implements Comparator<TreeNode> {
        public int compare(TreeNode t1, TreeNode t2) {
            if (t1.priority != t2.priority) return t1.priority - t2.priority;
//            return (-t1.moves + t2.moves);
            return (t1.board.manhattan() - t2.board.manhattan());
        }
    }
    
    private class TreeNode {
        private TreeNode father = null;
        private int moves;
        private Board board;
        private int priority;
        public TreeNode(Board curBoard) {
            board = curBoard;
            moves = 0;
            priority = 0;
        }
        
        public TreeNode(Board curBoard, TreeNode fatherNode, int moved, int priority) {
            board = curBoard;
            father = fatherNode;
            moves = moved;
            this.priority = priority;
        }
    }
    
    public static void main(String[] args) {
        // solve a slider puzzle (given below)
        for (String filename : args) {
            In in = new In(filename);
            int n = in.readInt();
            int[][] tiles = new int[n][n];
            for (int i = 0; i < n; i++) 
                for (int j = 0; j < n; j++) {
                tiles[i][j] = in.readInt();
            }
            // solve the slider puzzle
            Board initial = new Board(tiles);
            Solver solver = new Solver(initial);
            StdOut.println(filename + ": " + solver.moves());
            int cnt = 0;
//            for (Board board : solver.solution()) {
//                StdOut.printf("solution %d:\n", cnt++);
//                StdOut.printf("manhattan = %d\n", board.manhattan());
//                StdOut.printf("hamming = %d\n", board.hamming());
//                StdOut.println(board);
//            }
        }
    }
}